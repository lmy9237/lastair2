package myVo;

import java.io.Serializable;

public class SearchReviewByTextVo implements Serializable {
	private int roomIdx;
	private int reviewIdx;
	private String review;
	private int userIdx;
	private double score;
	private String wirttenDate;
	
	public SearchReviewByTextVo(int roomIdx, int reviewIdx, String review, int userIdx, double score, String wirttenDate) {
		this.roomIdx = roomIdx;
		this.reviewIdx = reviewIdx;
		this.review = review;
		this.userIdx = userIdx;
		this.score = score;
		this.wirttenDate = wirttenDate;
	}

	public int getRoomIdx() {
		return roomIdx;
	}

	public int getReviewIdx() {
		return reviewIdx;
	}

	public String getReview() {
		return review;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public double getScore() {
		return score;
	}

	public String getWirttenDate() {
		return wirttenDate;
	}
}