package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserValidationService {


	@Override
	public boolean validation(JobSeeker jobSeeker) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()), jobSeeker.getFirstName().toUpperCase(),
					jobSeeker.getLastName().toUpperCase(), Integer.parseInt(jobSeeker.getBirthYear()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean fakeValidation(JobSeeker jobSeeker) {
		
		return true;
	}

}
