package com.zensar.service;

import java.util.List;

import com.zensar.entity.AdvertiseCategory;
import com.zensar.entity.AdvertiseStatus;

public interface MasterService {
	List<AdvertiseCategory> getAllAdvertisementCategories();

	List<AdvertiseStatus> getAllAdvertisementStatus();

}
