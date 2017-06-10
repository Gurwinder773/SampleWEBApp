package utils;

import java.util.List;

import model.ListResponseModel;

public class Utils {

	public static <T> ListResponseModel<T> getListReponseModel(List<T> list, boolean isSuccess, String message) {

		ListResponseModel<T> listResponseModel = new ListResponseModel<>();

		if (isSuccess) {
			listResponseModel = new ListResponseModel<>();
			listResponseModel.setData(list);
			listResponseModel.setStatus(Constant.STATUS_SUCCESS);
			listResponseModel.setMessage(Constant.MESSAGE_SUCCESS);
		} else {
			listResponseModel = new ListResponseModel<>();
			listResponseModel.setData(null);
			listResponseModel.setStatus(Constant.STATUS_FAIL);
			listResponseModel.setMessage(Constant.MESSAGE_FAIL + ": " + message);
		}
		return listResponseModel;
	}

}
