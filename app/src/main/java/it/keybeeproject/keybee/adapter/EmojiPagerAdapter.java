package it.keybeeproject.keybee.adapter;

import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.model.EmojiCategory;

/**
 * Created by c161 on 19/09/16.
 */
public class EmojiPagerAdapter extends PagerAdapter {

	private static final String TAG = EmojiPagerAdapter.class.getSimpleName();

	private Context context;
	private LayoutInflater inflater;
	private ArrayList<EmojiCategory> emojiCategories;
	private EmojiAdapter.EmojiClickListener listenerEmojiClick;

	public EmojiPagerAdapter(Context context, EmojiAdapter.EmojiClickListener emojiClickListener) {
		this.context = context;
		emojiCategories = EmojiCategory.getCategories();
		inflater = LayoutInflater.from(context);
		listenerEmojiClick = emojiClickListener;
	}

	@Override
	public int getCount() {
		return emojiCategories.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View viewEmojiContainer = inflater.inflate(R.layout.layout_emoji_container, container, false);

		RecyclerView recyclerView = (RecyclerView) viewEmojiContainer.findViewById(R.id.recycler_emoji);
		GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 8);
		gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(gridLayoutManager);
		EmojiAdapter adpEmoji = new EmojiAdapter(context, emojiCategories.get(position),
				listenerEmojiClick);
		recyclerView.setAdapter(adpEmoji);

		container.addView(viewEmojiContainer);

		return viewEmojiContainer;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}
}
