package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import models.CommitsResult;

public class Commitservices implements WSBodyReadables, WSBodyWritables{

	private WSClient ws;
	public Map<String, Integer> result = new LinkedHashMap<>();
	
	
	CommitsResult cr;
	
	@Inject
	public Commitservices(WSClient ws) {
		this.ws = ws;
	}

	
	/**
	 * This method returns the entire data for repository commits. And also it is used for authorization purpose to Github API to get more than 100 commits data.
	 * This method computes addition, deletion and average number of additons and deletions value for Repository Commits.
	 * @param ownerName
	 * @param repoName
	 * @return Completion Stage of list containing commitsdata
	 */
	
	public CompletableFuture<List<CommitsResult>> get_commits_data(String ownerName, String repoName) {
		List<Integer> addition_list = new ArrayList<>();
		List<Integer> deletion_list = new ArrayList<>();
		List<CommitsResult> commits_model = new ArrayList<>();
		return CompletableFuture.supplyAsync(() -> {
			Optional<Integer> max_Addition, max_deletion, min_Addition, min_deletion, avg_addition, avg_deletion;
			String commits_url = "https://api.github.com/repos" + "/" + ownerName + "/" + repoName + "/commits";
			System.out.println(commits_url);
			WSRequest request = ws.url(commits_url).addHeader("Authorization", "token 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");
			request.addQueryParameter("per_page", "100");
			request.addQueryParameter("page", "1");
			request.setMethod("GET");
			CompletionStage<JsonNode> json_value = request.get().thenApply(r -> r.getBody(json()));
			try {
				List<String> sha_list = new ArrayList<String>();
				for (JsonNode sha : json_value.toCompletableFuture().get()) {
					sha_list.add(sha.get("sha").asText());
				}

				System.out.println("Sha size: " + sha_list.size());
				for (int i = 0; i < sha_list.size(); i++) {
					WSRequest ws_req = ws.url(commits_url + "/" + sha_list.get(i)).addHeader("Authorization",
							"token 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");
					ws_req.setMethod("GET");
					CompletionStage<JsonNode> resFromRequest = ws_req.get().thenApply(result -> result.asJson());
					JsonNode temp_var = resFromRequest.toCompletableFuture().get();
					addition_list.add(temp_var.get("stats").findPath("additions").asInt());
					deletion_list.add(temp_var.get("stats").findPath("deletions").asInt());
					max_Addition = addition_list.stream().max(Integer::compare);
					min_Addition = addition_list.stream().min(Integer::compare);
					avg_addition = Optional.of(addition_list.stream().reduce(0, Integer::sum) / sha_list.size());
					max_deletion = deletion_list.stream().max(Integer::compare);
					min_deletion = deletion_list.stream().min(Integer::compare);
					avg_deletion = Optional.of(deletion_list.stream().reduce(0, Integer::sum) / sha_list.size());
					cr = new CommitsResult(temp_var.get("author").findPath("avatar_url").asText(),
							temp_var.get("author").findPath("login").asText(), temp_var.get("commit").findPath("message").asText(),
							temp_var.get("stats").findPath("additions").asText(),
							temp_var.get("stats").findPath("deletions").asText(), temp_var.get("stats").findPath("total").asText(),
							max_Addition, min_Addition, max_deletion, min_deletion, avg_addition, avg_deletion);
					commits_model.add(cr);
				}

			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < commits_model.size(); i++) {
				System.out.println(commits_model.get(i).max_addition);
			}
			return commits_model;

		});
	}
	
}