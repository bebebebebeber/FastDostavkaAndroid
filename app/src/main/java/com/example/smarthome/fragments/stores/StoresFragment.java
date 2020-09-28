package com.example.smarthome.fragments.stores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.toolbox.NetworkImageView;
import com.example.smarthome.Network.AuthorizedService;
import com.example.smarthome.Network.ImageRequester;
import com.example.smarthome.Network.models.Categories;
import com.example.smarthome.Network.models.Profile;
import com.example.smarthome.Network.utils.CommonUtils;
import com.example.smarthome.R;
import com.example.smarthome.constants.Urls;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoresFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_stores, container, false);
        //String[] items = new String[]{"1", "2", "three"};


        CommonUtils.showLoading(getContext());
        AuthorizedService.getInstance()
                .getJSONApi()
                .categories()
                .enqueue(new Callback<List<Categories>>() {
                    @Override
                    public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                        if (response.errorBody() == null && response.isSuccessful()) {
                            List<Categories> c = response.body();
                            List<String> names
                                    =c.stream().map(x->x.getName()).collect(Collectors.toList());
                            String[] items = names.toArray(new String[0]);
                            ArrayAdapter<String>adapter = new ArrayAdapter<String>(view.getContext(),
                                    android.R.layout.simple_spinner_item,items);
                            AutoCompleteTextView editTextFilledExposedDropdown =
                                    view.findViewById(R.id.filled_exposed_dropdown);
                            //editTextFilledExposedDropdown.setText("1",false);
                            editTextFilledExposedDropdown.setAdapter(adapter);
                            editTextFilledExposedDropdown.setEnabled(false);
                            CommonUtils.hideLoading();

                        }
                        else {
                            CommonUtils.hideLoading();

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Categories>> call, Throwable t) {
                        CommonUtils.hideLoading();

                    }
                });
        return view;
    }
}
