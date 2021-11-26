package org.arm.resource.mngt.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.arm.resource.mngt.entity.Resource;
import org.arm.resource.mngt.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@GetMapping("/resource/list")
	public ResponseEntity<List<Resource>> getAllResources() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Resource details are retrived successfully");
		List<Resource> resourceList = resourceService.getAllResource();
		return ResponseEntity.ok().headers(headers).body(resourceList);
	}

	@PostMapping("/resource/create")
	public void createResource() {
		Resource resource = new Resource();
		resource.setAvailability("Available");
		resource.setCreateDate(new Timestamp(new Date().getTime()));
		resource.setIsDeleted(0);
		resource.setResourceName("T User 2");
		resource.setResourceType("B");

		resourceService.save(resource);
	}

}
