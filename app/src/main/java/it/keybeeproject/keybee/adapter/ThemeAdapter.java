package it.keybeeproject.keybee.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.keybeeproject.keybee.Global.Constant;
import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.activity.ThemeMarketActivity;
import it.keybeeproject.keybee.model.Theme;
import it.keybeeproject.keybee.utility.DrawableHelper;
import it.keybeeproject.keybee.utility.PrefData;

/**
 * Created by c161 on 10/10/16.
 */
public class ThemeAdapter extends BaseAdapter {

	private static final String TAG = ThemeAdapter.class.getSimpleName();

	private Context context;
	private ArrayList<Theme> arrListTheme;
	private LayoutInflater inflater;
	private int selectedThemePosition;

	public ThemeAdapter(Context context, ArrayList<Theme> arrListTheme) {
		this.context = context;
		this.arrListTheme = arrListTheme;
		inflater = LayoutInflater.from(context);
		selectedThemePosition = PrefData.getIntPrefs(context, PrefData.KEY_SELECTED_THEME_POSITION);
	}

	@Override
	public int getCount() {
		return arrListTheme.size();
	}

	@Override
	public Object getItem(int position) {
		return arrListTheme.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_list_theme, null);

			holder = new ViewHolder();
			holder.imgCurrentTheme = convertView.findViewById(R.id.img_current_theme);
			holder.imgApplyTheme = convertView.findViewById(R.id.img_apply_theme);
			holder.textThemeTitle = convertView.findViewById(R.id.text_themeTitle);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		try {
			convertView.setBackgroundColor(arrListTheme.get(position).getCellBackgroundColor());
			if (position == selectedThemePosition) {
				holder.imgCurrentTheme.setImageDrawable(DrawableHelper
						.withContext(context)
						.withColor(arrListTheme.get(position).getCellFontColor())
						.withDrawable(R.drawable.ic_check)
						.tint()
						.get());
			} else {
				holder.imgCurrentTheme.setImageDrawable(null);
			}
			holder.textThemeTitle.setText(arrListTheme.get(position).getName());
			holder.textThemeTitle.setTextColor(arrListTheme.get(position).getCellFontColor());
			if (!PrefData.getBooleanPrefs(context, Constant.SKU)) {
				holder.imgApplyTheme.setImageDrawable(DrawableHelper
						.withContext(context)
						.withColor(arrListTheme.get(position).getCellFontColor())
						.withDrawable(arrListTheme.get(position).isPurchased() ? R.drawable.ic_arrow_right : R.drawable.ic_add)
						.tint()
						.get());
			}else{
				holder.imgApplyTheme.setImageDrawable(DrawableHelper
						.withContext(context)
						.withColor(arrListTheme.get(position).getCellFontColor())
						.withDrawable(R.drawable.ic_arrow_right)
						.tint()
						.get());
			}
		} catch (Exception e) {
			Log.e(TAG, "getView Exception : ", e);
		}

		return convertView;
	}

	private class ViewHolder {
		ImageView imgCurrentTheme, imgApplyTheme;
		TextView textThemeTitle;
	}

	public void setSelectedThemePosition(int selectedThemePosition) {
		this.selectedThemePosition = selectedThemePosition;
	}
}
