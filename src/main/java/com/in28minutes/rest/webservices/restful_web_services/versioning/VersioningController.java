package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	@GetMapping("/v1/persion")
	public PersionV1 getFirstVersionofPersion() {

		return new PersionV1("Balaji Rakh");

	}

	@GetMapping("/v2/persion")
	public PersionV2 getSecondVersionofPersion() {

		return new PersionV2(new Name("Balaji", "Rakh"));

	}

	// when you want to return in key value format using request param.

	@GetMapping(path = "persion", params = "version=1")
	public PersionV1 getFirstVersionofPersionRequestParameter() {

		return new PersionV1("Balaji Rakh");

	}

	@GetMapping(path = "persion", params = "version=2")
	public PersionV2 getSecondVersionofPersionRequestParameter() {

		return new PersionV2(new Name("Balaji", "Rakh"));

	}

	// using header.

	@GetMapping(path = "persion/header", headers = "X-API-VERSION=1")
	public PersionV1 getFirstVersionofPersionRequestHeader() {

		return new PersionV1("Balaji Rakh");

	}

	// using accept

	@GetMapping(path = "persion/accept", produces = "application/json")
	public PersionV1 getFirstVersionofPersionAcceptHeader() {

		return new PersionV1("Balaji Rakh");

	}

	@GetMapping(path = "persion/accept", produces = "application/xml")
	public PersionV2 getSecondVersionofPersionAcceptHeader() {

		return new PersionV2(new Name("Balaji", "Rakh"));

	}

}
