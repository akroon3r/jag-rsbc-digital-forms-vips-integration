package ca.bc.gov.open.pssg.rsbc.digitalforms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.bc.gov.open.jagvipsclient.disclosure.DisclosureResponse;
import ca.bc.gov.open.jagvipsclient.prohibition.DocumentDisclosureInfo;
import ca.bc.gov.open.pssg.rsbc.digitalforms.config.ConfigProperties;

/**
 * 
 * Disclosure Service operations Implementation
 * 
 * @author sivakaruna
 *
 */
@Service
public class DisclosureServiceImpl implements DisclosureService {

	private final Logger logger = LoggerFactory.getLogger(DisclosureServiceImpl.class);

	@Autowired
	ca.bc.gov.open.jagvipsclient.disclosure.DisclosureService disclosureService;

	@Autowired
	private ConfigProperties properties;

	@Override
	public DisclosureResponse getDisclosureDocument(String documentId, String correlationId) {
		logger.info("Processing get disclosure document request");

		return disclosureService.getDisclosureDocument(documentId, properties.getOrdsUserGuid(), correlationId);
	}

	@Override
	public DisclosureResponse setDisclosureSent(String noticeNumber, String correlationId,
			DocumentDisclosureInfo disclosureInfo) {
		logger.info("Processing set disclosure document as sent request");

		return disclosureService.setDisclosureSent(noticeNumber, disclosureInfo.getDocumentId(),
				disclosureInfo.getDisclosedDtm(), properties.getOrdsUserGuid(), correlationId);
	}

}
