package br.rpm.call.list.main.adapter.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.View;

import br.rpm.call.list.BR;
import br.rpm.call.list.R;
import br.rpm.call.list.model.CallDetail;

public class CallDetailViewHolder extends BaseViewHolder<CallDetail> {

	@LayoutRes
	public static final int LAYOUT = R.layout.widget_contact_item;

	private ViewDataBinding bind;

	public CallDetailViewHolder(View itemView) {
		super(itemView);

		this.bind = DataBindingUtil.bind(itemView);
	}

	@Override
	public void bind(CallDetail contact) {
		bind.setVariable(BR.contact, contact);
	}
}
