package ca.bc.gov.open.pssg.rsbc.digitalforms.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ca.bc.gov.open.pssg.rsbc.digitalforms.model.JSONResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.service.IRPQueryServiceImpl;


/**
 * 
 * IRP Query Service Controller Tests. 
 * 
 * @author shaunmillargov
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class IRPQueryServiceControllerTests {

	private final String JSON_RESPONSE_GOOD = "IRP result";

	@MockBean
	private IRPQueryServiceImpl irpService;

	private IRPQueryServiceController controller;

	@BeforeEach
	public void init() {
		controller = new IRPQueryServiceController(irpService);
		when(irpService.getIRP(1L)).thenReturn(JSON_RESPONSE_GOOD);
	}

	// Test irpGet for 201 returned on success.
	// TODO - update when fully functional
	@Test
	void irpGetReturns201() {
		ResponseEntity<JSONResponse<String>> resp = controller.irpGet(1L);
		Assert.assertEquals(HttpStatus.CREATED, resp.getStatusCode());
	}

	// Test irpGet for proper JSON reponse on success.
	// TODO - update when fully functional
	@Test
	void irpGetReturnsSuccess() {
		ResponseEntity<JSONResponse<String>> resp = controller.irpGet(1L);
		Assert.assertEquals(JSON_RESPONSE_GOOD, resp.getBody().getData());
	}

	// Test irpGet for IRP not found.
	// TODO - update when fully functional
	@Test
	void irpGetReturnsNotFound() {
		// test for not found
	}

	// Test irpGet for exception state.
	// TODO - update when fully functional
	@Test
	void irpGetReturnException() {
		// test for exception 
	}

}
