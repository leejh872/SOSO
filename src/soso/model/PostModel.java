package soso.model;

import soso.entities.Post;

public class PostModel extends Post {

	private int cmtCnt;

	public int getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
	
}
