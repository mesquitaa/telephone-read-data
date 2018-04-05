package br.rpm.call.list.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.getninjas.pro.koins.model.CallModel;
import br.rpm.call.list.main.adapter.factory.TypeFactory;
import br.rpm.call.list.main.adapter.factory.impl.TypeFactoryImpl;
import br.rpm.call.list.main.adapter.viewholder.BaseViewHolder;
import br.rpm.call.list.model.CallDetail;

public class CallDetailAdapter extends RecyclerView.Adapter<BaseViewHolder> {

	private List<CallModel> mElements = new ArrayList<>();
	private final TypeFactory mTypeFactory = new TypeFactoryImpl();

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View contactView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
		return mTypeFactory.createViewHolder(contactView, viewType);
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
		holder.bind(mElements.get(position));
	}

	@Override
	public int getItemCount() {
		return mElements.size();
	}

	@Override
	public int getItemViewType(int position) {
		return mElements.get(position).type(mTypeFactory);
	}

	public void addAll(List<CallDetail> details) {
		this.mElements.addAll(details);
		notifyDataSetChanged();
	}
}
