package com.ci.core;

/**
 * author: mzbedat
 * The Interface JobRunnable.
 */
public interface JobRunnable {
	
	/**
	 * Run job.
	 *
	 * @param jobId the job id
	 */
	public void runJob(int jobId);
	
	/**
	 * Stop job.
	 *
	 * @param jobId the job id
	 */
	public void stopJob(int jobId);
	
	/**
	 * Trigger job.
	 *
	 * @param jobId the job id
	 */
	public void triggerJob(int jobId);
}
