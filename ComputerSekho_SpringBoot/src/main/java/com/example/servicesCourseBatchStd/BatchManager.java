package com.example.servicesCourseBatchStd;

import java.util.List;

import java.util.Optional;

import com.example.entityCourseBatchStd.Batch;



public interface BatchManager {
	void save(Batch ref);
	List<Batch> getAll();
	Batch getBatch(int batchno);
	List<Batch> getUpcomingBatch();
	List<Batch> getCurrentBatch();
	List<Batch> getPastBatch();
	List<Batch> getBatchByName(String batchName);
	List<Batch> getBatchByCourseId(int cid);
}

