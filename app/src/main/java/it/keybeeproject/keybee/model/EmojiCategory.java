package it.keybeeproject.keybee.model;

import java.util.ArrayList;

/**
 * Created by c161 on 19/09/16.
 */
public class EmojiCategory {

    private static final String TAG = EmojiCategory.class.getSimpleName();

    private int categoryId;
    private ArrayList<Emoji> emojies;

    public static final int PEOPLE = 1;
    public static final int NATURE = 3;
    public static final int THING = 2;
    public static final int PLACE = 4;
    public static final int SYMBOL = 5;
    public static final int FLAG = 6;

    public EmojiCategory(int categoryId, ArrayList<Emoji> emojies) {
        this.categoryId = categoryId;
        this.emojies = emojies;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public ArrayList<Emoji> getEmojies() {
        return emojies;
    }

    public void setEmojies(ArrayList<Emoji> emojies) {
        this.emojies = emojies;
    }

    public static ArrayList<EmojiCategory> getCategories() {
        ArrayList<EmojiCategory> emojiCategories = new ArrayList<>();
        emojiCategories.add(new EmojiCategory(PEOPLE, EmojiSmiley.getEmojies()));
        emojiCategories.add(new EmojiCategory(THING, EmojiPeople.getEmojies()));
        emojiCategories.add(new EmojiCategory(NATURE, EmojiNature.getEmojies()));
        emojiCategories.add(new EmojiCategory(PLACE, EmojiPlace.getEmojies()));
        emojiCategories.add(new EmojiCategory(SYMBOL, EmojiHobies.getEmojies()));
        emojiCategories.add(new EmojiCategory(FLAG, EmojiFlag.getEmojies()));
        return emojiCategories;
    }
}