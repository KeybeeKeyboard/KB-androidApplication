package it.keybeeproject.keybee.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.model.Emoji;
import it.keybeeproject.keybee.model.EmojiCategory;
import it.keybeeproject.keybee.utility.PrefData;

import static androidx.annotation.Dimension.SP;

/**
 * Created by c161 on 19/09/16.
 */
public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.ViewHolder> {

	private static final String TAG = EmojiAdapter.class.getSimpleName();

	private Context context;
	private LayoutInflater inflater;
	private ArrayList<Emoji> arrListEmoji;
	private boolean isSmallSize;

	private EmojiClickListener listenerEmojiClick;

	public interface EmojiClickListener {
		void onClickEmoji(String emoji);
	}

	public EmojiAdapter(Context context, EmojiCategory emojiCategory, EmojiClickListener emojiClickListener) {
		this.context = context;
		listenerEmojiClick = emojiClickListener;
		isSmallSize = !PrefData.getBooleanPrefs(context, PrefData.KEY_IS_KB_SIZE_FULL_B, false)
						&& PrefData.getFloatPrefs(context, PrefData.KEY_KB_SIZE_F, PrefData.VAL_KB_SIZE_PHONE_MEDIUM)
							< PrefData.VAL_KB_SIZE_PHONE_SMALL;

		ArrayList<Emoji> arrEmoji = emojiCategory.getEmojies();

		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			this.arrListEmoji = new ArrayList<>();
			for (int i = 0; i < arrEmoji.size(); i++) {
				if (arrEmoji.get(i).isSupportedPre19()) {
					this.arrListEmoji.add(arrEmoji.get(i));
				}
			}
		} else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT && emojiCategory.getCategoryId() == EmojiCategory.SYMBOL) {
			this.arrListEmoji = new ArrayList<>();
			for (int i = 0; i < arrEmoji.size(); i++) {
				if (arrEmoji.get(i).isSupportedPre21()) {
					this.arrListEmoji.add(arrEmoji.get(i));
				}
			}
		} else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1 && emojiCategory.getCategoryId() == EmojiCategory.PLACE) {
			this.arrListEmoji = new ArrayList<>();
			for (int i = 0; i < arrEmoji.size(); i++) {
				if (arrEmoji.get(i).isSupportedPre22()) {
					this.arrListEmoji.add(arrEmoji.get(i));
				}
			}
		} else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N ) {
			this.arrListEmoji = new ArrayList<>();
			for (int i = 0; i < arrEmoji.size(); i++) {
				if (arrEmoji.get(i).isSupportedPre24()) {
					this.arrListEmoji.add(arrEmoji.get(i));
				}
			}
		}else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O ) {
			this.arrListEmoji = new ArrayList<>();
			for (int i = 0; i < arrEmoji.size(); i++) {
				if (arrEmoji.get(i).isSupportedPre26()) {
					this.arrListEmoji.add(arrEmoji.get(i));
				}
			}
		}else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P ) {
			this.arrListEmoji = new ArrayList<>();
			for (int i = 0; i < arrEmoji.size(); i++) {
				if (arrEmoji.get(i).isSupportedPre28()) {
					this.arrListEmoji.add(arrEmoji.get(i));
				}
			}
		}else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q ) {
			this.arrListEmoji = new ArrayList<>();
			for (int i = 0; i < arrEmoji.size(); i++) {
				if (arrEmoji.get(i).isSupportedPre29()) {
					this.arrListEmoji.add(arrEmoji.get(i));
				}
			}
		}else {
			this.arrListEmoji = arrEmoji;
		}

		inflater = LayoutInflater.from(context);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ViewHolder(inflater.inflate(R.layout.item_grid_emoji, parent, false), isSmallSize);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		holder.buttonEmoji.setText(arrListEmoji.get(position).getEmoji());

		holder.buttonEmoji.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listenerEmojiClick.onClickEmoji(arrListEmoji.get(position).getEmoji());
			}
		});
	}

	@Override
	public int getItemCount() {
		return arrListEmoji.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		Button buttonEmoji;
		public ViewHolder(View itemView, boolean isTabSize) {
			super(itemView);
			buttonEmoji = (Button) itemView.findViewById(R.id.button_emoji);
			if (isTabSize) {
				buttonEmoji.setTextSize(SP, 18);
			}
			buttonEmoji.setTextColor(Color.GRAY);
		}
	}
}
