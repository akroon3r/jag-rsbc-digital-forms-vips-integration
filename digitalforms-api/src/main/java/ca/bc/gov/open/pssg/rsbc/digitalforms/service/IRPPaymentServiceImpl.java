package ca.bc.gov.open.pssg.rsbc.digitalforms.service;

import org.springframework.stereotype.Service;

import ca.bc.gov.open.pssg.rsbc.digitalforms.model.IRPPaymentStatusResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.model.IRPPaymentTransRequest;

/**
 * 
 * @author shaunmillargov
 *
 */
@Service
public class IRPPaymentServiceImpl implements IRPPaymentService {

	@Override
	public boolean setIRPReviewPaid(Long irpNoticeNumber, IRPPaymentTransRequest request) {
		
		// TODO Service to be built out here
		return true;
	}

	@Override
	public IRPPaymentStatusResponse getIRPReviewPaymentStatus(Long irpNoticeNumber) {
		// TODO Service to be built out here
		return new IRPPaymentStatusResponse("1");
	}
	
}




