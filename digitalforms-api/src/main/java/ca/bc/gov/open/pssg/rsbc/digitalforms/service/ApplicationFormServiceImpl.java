package ca.bc.gov.open.pssg.rsbc.digitalforms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.bc.gov.open.pssg.rsbc.digitalforms.model.ApplicationFormData;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.DigitalFormPatchRequest;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.DigitalFormPostRequest;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.application.ApplicationResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.application.ApplicationService;
import ca.bc.gov.open.pssg.rsbc.digitalforms.util.DigitalFormsConstants;

/**
 * 
 * Application form Service operations Implementation
 * 
 * @author sivakaruna
 *
 */
@Service
public class ApplicationFormServiceImpl implements ApplicationFormService {

	@Autowired
	private ApplicationService applicationService;

	@Override
	public ApplicationResponse getApplicationForm(String formGuid) {
		return applicationService.getApplication(formGuid);
	}

	@Override
	public ApplicationResponse postApplicationForm(String formType, String noticeNo, ApplicationFormData formData) {
		DigitalFormPostRequest request = new DigitalFormPostRequest();

		request.setElectronicAddressTxt(formData.getEmail());
		request.setFaxNo(formData.getFaxNo());
		request.setFirstGivenNm(formData.getFirstGivenNm());
		request.setFormXml(formData.getFormData());
		request.setManualEntryYn(formData.getManualEntryYN());
		request.setNoticeSubjectCd(formData.getNoticeSubjectCd());
		request.setNoticeTypeCd(formType);
		request.setPhoneNo(formData.getPhoneNo());
		request.setPresentationFormatCd(formData.getPresentationTypeCd());
		request.setProhibitionNoticeNo(noticeNo);
		request.setReviewApplicationTypeCd(formType);
		request.setReviewRoleTypeCd(formData.getReviewRoleTypeCd());
		request.setSecondGivenNm(formData.getSecondGivenNm());
		request.setSurnameNm(formData.getSurnameNm());
		request.setUserId(DigitalFormsConstants.ORDS_USER_ID);

		return applicationService.postApplication(request);
	}

	@Override
	public ApplicationResponse patchApplicationForm(String formType, String formGuid, ApplicationFormData formData) {
		DigitalFormPatchRequest request = new DigitalFormPatchRequest();

		request.setElectronicAddressTxt(formData.getEmail());
		request.setFaxNo(formData.getFaxNo());
		request.setFirstGivenNm(formData.getFirstGivenNm());
		request.setFormXml(formData.getFormData());
		request.setManualEntryYn(formData.getManualEntryYN());
		request.setNoticeSubjectCd(formData.getNoticeSubjectCd());
		request.setNoticeTypeCd(formType);
		request.setPhoneNo(formData.getPhoneNo());
		request.setPresentationFormatCd(formData.getPresentationTypeCd());
		request.setReviewApplicationTypeCd(formType);
		request.setReviewRoleTypeCd(formData.getReviewRoleTypeCd());
		request.setSecondGivenNm(formData.getSecondGivenNm());
		request.setSurnameNm(formData.getSurnameNm());
		request.setUserId(DigitalFormsConstants.ORDS_USER_ID);

		return applicationService.patchApplication(formGuid, request);
	}
}
