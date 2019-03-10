package com.tencent.gaio.workorder.vo;

import java.util.HashMap;
import java.util.Map;

/**
 *     操作任务接口入参
 * @author tphe05
 */
public class TaskActionReqVo{
	private String action;
	private String assignee;
	private String candidateUser;
	private String candidateGroup;
	private Map<String, Object> variables = new HashMap<>();

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public Map<String, Object> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
	public String getCandidateUser() {
		return candidateUser;
	}
	public void setCandidateUser(String candidateUser) {
		this.candidateUser = candidateUser;
	}
	public String getCandidateGroup() {
		return candidateGroup;
	}
	public void setCandidateGroup(String candidateGroup) {
		this.candidateGroup = candidateGroup;
	}
}