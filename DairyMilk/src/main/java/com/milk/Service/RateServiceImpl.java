package com.milk.Service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.milk.Model.Rate;
import com.milk.Model.RateDTO;
import com.milk.Model.ConstantValues;
import com.milk.Model.Farmer;
import com.milk.Repository.RateRepository;
import com.milk.Repository.ConstantValuesRepository;

@Service
public class RateServiceImpl extends Rate implements RateServiceInterface {

	@Autowired
	public ConstantValuesServiceInterface csi;

	@Autowired
	public RateRepository arepo;

	@Override
	public Rate addrateinservice(Rate acc) {

		Rate calculatedAcc = calculateRate(acc);
		return arepo.save(calculatedAcc);

	}

	@Override
	public Rate updaterateinservice(Rate acc) {
		// TODO Auto-generated method stub
		return arepo.save(acc);
	}

	@Override
	public void deleterateinservice(int id) {
		// TODO Auto-generated method stub
		arepo.delete(arepo.getById(id));
	}

	double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("##.#");
		return Double.valueOf(df2.format(val));
	}

	@Override
	public List<Rate> getallrate() {
		// TODO Auto-generated method stub

		return arepo.findAll();
	}

	@Override
	public Rate getrate(int fid) {
		// TODO Auto-generated method stub

		return arepo.findById(fid).get();
	}

	@Override
	public Rate calculateRate(Rate acc) {
		ConstantValues rateObj = csi.getLatestValue();

		double fatDiff = 0;
		double snfDiff = 0;
		double rateofmilk = 0;

		double degreeUser = acc.getDegree();
		double fatUser = acc.getFat();

		double quantity = acc.getMilkPurchaseQuantity();

		double snfUser = ((degreeUser / 4) + (0.21 * fatUser) + 0.36);
		snfUser = RoundTo2Decimals(snfUser);
		acc.setSnf(snfUser);
		String mType = acc.getMilkType();

		if (mType.equalsIgnoreCase("Cow")) {
			if ((fatUser - 3.5) > 0) {
				fatDiff = ((fatUser - 3.5) * 10) * rateObj.getFatInc();
			} else if ((fatUser - 3.5) < 0) {
				fatDiff = ((fatUser - 3.5) * 10) * rateObj.getFatDec();
			}

			if ((snfUser - 8.5) > 0) {
				snfDiff = ((snfUser - 8.5) * 10) * rateObj.getSnfInc();
			} else if ((snfUser - 8.5) < 0) {
				snfDiff = ((snfUser - 8.5) * 10) * rateObj.getSnfInc();
			}
			rateofmilk = rateObj.getRateOfMilk() + fatDiff + snfDiff;

		}

		else if (mType.equalsIgnoreCase("Buffalo")) {
			if ((fatUser - 5) > 0) {
				fatDiff = ((fatUser - 5) * 10) * rateObj.getFatB();
			} else if ((fatUser - 5) < 0) {
				fatDiff = ((fatUser - 5) * 10) * rateObj.getFatB();
			}

			if ((snfUser - 9) > 0) {
				snfDiff = ((snfUser - 9) * 10) * rateObj.getSnfB();
			} else if ((snfUser - 9) < 0) {
				snfDiff = ((snfUser - 9) * 10) * rateObj.getSnfB();
			}
			rateofmilk = rateObj.getRateOfMilkB() + fatDiff + snfDiff;

		}

		rateofmilk = RoundTo2Decimals(rateofmilk);
		acc.setRateofmilk(rateofmilk);

		double purchasePricePerLitr = rateofmilk * quantity;

		acc.setPurchasePricePerLitre(purchasePricePerLitr);

		acc.setUpdateId(rateObj.getUid());
		return acc;
	}

	@Override
	public List<Rate> getBetweenDatesByID(int id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String start = dateFormat.format(startDate);
		String end = dateFormat.format(endDate);

		List<Rate> r =  arepo.findByDateBetween(id, start, end);
		
		//System.out.println(r.toArray().toString());
		
		return r;
	}

	@Override
	public List<Rate> getDatesBetween(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String startD = dateFormat.format(startDate);
		String endD = dateFormat.format(endDate);
		return arepo.findByDateAllID(startD, endD);
	}

}
