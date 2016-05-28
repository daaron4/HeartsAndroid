package com.companyname.hearts.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.companyname.hearts.R;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private final int WIDTH = 50;
    private final int HEIGHT = 80;

	private Bitmap aceSpades, deuceSpades, threeSpades, fourSpades, fiveSpades,
			sixSpades, sevenSpades, eightSpades, nineSpades, tenSpades,
			jackSpades, queenSpades, kingSpades, aceDiamonds, deuceDiamonds,
			threeDiamonds, fourDiamonds, fiveDiamonds, sixDiamonds,
			sevenDiamonds, eightDiamonds, nineDiamonds, tenDiamonds,
			jackDiamonds, queenDiamonds, kingDiamonds, aceHearts, deuceHearts,
			threeHearts, fourHearts, fiveHearts, sixHearts, sevenHearts,
			eightHearts, nineHearts, tenHearts, jackHearts, queenHearts,
			kingHearts, aceClubs, deuceClubs, threeClubs, fourClubs, fiveClubs,
			sixClubs, sevenClubs, eightClubs, nineClubs, tenClubs, jackClubs,
			queenClubs, kingClubs;

	private Context context;
    private ArrayList<Card> deck;

	public Deck(Context context) {
		this.context = context;
		deck = new ArrayList<>();
		createDeck();
	}

	public void createDeck() {
		// load images:
		loadImages();

		// Add all cards:
		deck.add(new Card(Rank.Ace, Suit.Spades, aceSpades));
		deck.add(new Card(Rank.Deuce, Suit.Spades, deuceSpades));
		deck.add(new Card(Rank.Three, Suit.Spades, threeSpades));
		deck.add(new Card(Rank.Four, Suit.Spades, fourSpades));
		deck.add(new Card(Rank.Five, Suit.Spades, fiveSpades));
		deck.add(new Card(Rank.Six, Suit.Spades, sixSpades));
		deck.add(new Card(Rank.Seven, Suit.Spades, sevenSpades));
		deck.add(new Card(Rank.Eight, Suit.Spades, eightSpades));
		deck.add(new Card(Rank.Nine, Suit.Spades, nineSpades));
		deck.add(new Card(Rank.Ten, Suit.Spades, tenSpades));
		deck.add(new Card(Rank.Jack, Suit.Spades, jackSpades));
		deck.add(new Card(Rank.Queen, Suit.Spades, queenSpades));
		deck.add(new Card(Rank.King, Suit.Spades, kingSpades));

		deck.add(new Card(Rank.Ace, Suit.Diamonds, aceDiamonds));
		deck.add(new Card(Rank.Deuce, Suit.Diamonds, deuceDiamonds));
		deck.add(new Card(Rank.Three, Suit.Diamonds, threeDiamonds));
		deck.add(new Card(Rank.Four, Suit.Diamonds, fourDiamonds));
		deck.add(new Card(Rank.Five, Suit.Diamonds, fiveDiamonds));
		deck.add(new Card(Rank.Six, Suit.Diamonds, sixDiamonds));
		deck.add(new Card(Rank.Seven, Suit.Diamonds, sevenDiamonds));
		deck.add(new Card(Rank.Eight, Suit.Diamonds, eightDiamonds));
		deck.add(new Card(Rank.Nine, Suit.Diamonds, nineDiamonds));
		deck.add(new Card(Rank.Ten, Suit.Diamonds, tenDiamonds));
		deck.add(new Card(Rank.Jack, Suit.Diamonds, jackDiamonds));
		deck.add(new Card(Rank.Queen, Suit.Diamonds, queenDiamonds));
		deck.add(new Card(Rank.King, Suit.Diamonds, kingDiamonds));

		deck.add(new Card(Rank.Ace, Suit.Hearts, aceHearts));
		deck.add(new Card(Rank.Deuce, Suit.Hearts, deuceHearts));
		deck.add(new Card(Rank.Three, Suit.Hearts, threeHearts));
		deck.add(new Card(Rank.Four, Suit.Hearts, fourHearts));
		deck.add(new Card(Rank.Five, Suit.Hearts, fiveHearts));
		deck.add(new Card(Rank.Six, Suit.Hearts, sixHearts));
		deck.add(new Card(Rank.Seven, Suit.Hearts, sevenHearts));
		deck.add(new Card(Rank.Eight, Suit.Hearts, eightHearts));
		deck.add(new Card(Rank.Nine, Suit.Hearts, nineHearts));
		deck.add(new Card(Rank.Ten, Suit.Hearts, tenHearts));
		deck.add(new Card(Rank.Jack, Suit.Hearts, jackHearts));
		deck.add(new Card(Rank.Queen, Suit.Hearts, queenHearts));
		deck.add(new Card(Rank.King, Suit.Hearts, kingHearts));

		deck.add(new Card(Rank.Ace, Suit.Clubs, aceClubs));
		deck.add(new Card(Rank.Deuce, Suit.Clubs, deuceClubs));
		deck.add(new Card(Rank.Three, Suit.Clubs, threeClubs));
		deck.add(new Card(Rank.Four, Suit.Clubs, fourClubs));
		deck.add(new Card(Rank.Five, Suit.Clubs, fiveClubs));
		deck.add(new Card(Rank.Six, Suit.Clubs, sixClubs));
		deck.add(new Card(Rank.Seven, Suit.Clubs, sevenClubs));
		deck.add(new Card(Rank.Eight, Suit.Clubs, eightClubs));
		deck.add(new Card(Rank.Nine, Suit.Clubs, nineClubs));
		deck.add(new Card(Rank.Ten, Suit.Clubs, tenClubs));
		deck.add(new Card(Rank.Jack, Suit.Clubs, jackClubs));
		deck.add(new Card(Rank.Queen, Suit.Clubs, queenClubs));
		deck.add(new Card(Rank.King, Suit.Clubs, kingClubs));
	}

	public void shuffle() {
		// Shuffles the deck:
		int times = 0;
		while (times < 200) {
			Random rand = new Random();
			int randNum = rand.nextInt(52);
			int randNum2 = rand.nextInt(52);
			Card temp = new Card(deck.get(randNum).getRank(), deck.get(randNum)
					.getSuit(), deck.get(randNum).getCardImage());
			Card temp2 = new Card(deck.get(randNum2).getRank(), deck.get(
					randNum2).getSuit(), deck.get(randNum2).getCardImage());
			// if they are equal:
			while (temp.getRank() == temp2.getRank()
					&& temp.getSuit() == temp2.getSuit()) {
				randNum = rand.nextInt(52);
				randNum2 = rand.nextInt(52);
				temp = new Card(deck.get(randNum).getRank(), deck.get(randNum)
						.getSuit(), deck.get(randNum).getCardImage());
				temp2 = new Card(deck.get(randNum2).getRank(), deck.get(
						randNum2).getSuit(), deck.get(randNum2).getCardImage());
			}
			// they are not equal:
			deck.remove(randNum);
			deck.add(randNum, temp2);
			deck.remove(randNum2);
			deck.add(randNum2, temp);
			times++;
		}

	}

	public int getSize() {
		return deck.size();
	}

	public Card get(int index) {
		return deck.get(index);
	}

	public boolean contains(Card card) {
		return deck.contains(card);
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < 52; i++) {
			str += deck.get(i).getRank().toString() + " of "
					+ deck.get(i).getSuit().toString() + " ";
			if (i == 13 || i == 26 || i == 39 || i == 51)
				str += "\n";
		}
		return str;
	}

	public void deal(Player player1, Player player2, Player player3,
					 Player player4) {
		for (int i = 0; i < 13; i++) {
			player1.getHand().add(deck.get(i));
		}
		for (int i = 13; i < 26; i++) {
			player2.getHand().add(deck.get(i));
		}
		for (int i = 26; i < 39; i++) {
			player3.getHand().add(deck.get(i));
		}
		for (int i = 39; i < 52; i++) {
			player4.getHand().add(deck.get(i));
		}
	}

	public void remove(int index) {
		deck.remove(index);
	}

	public void add(int index, Card card) {
		deck.add(index, card);
	}

	public static Bitmap decodeSampledBitmapFromResource(Resources res,
			int resId, int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw HEIGHT and WIDTH of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and
			// keeps both
			// HEIGHT and WIDTH larger than the requested HEIGHT and WIDTH.
			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	public void loadImages() {

		aceSpades = decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ace_spades, WIDTH, HEIGHT);
		deuceSpades = decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.deuce_spades, WIDTH, HEIGHT);
		threeSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.three_spades, WIDTH, HEIGHT);
		fourSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.four_spades, WIDTH, HEIGHT);
		fiveSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.five_spades, WIDTH, HEIGHT);
		sixSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.six_spades, WIDTH, HEIGHT);
		sevenSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.seven_spades, WIDTH, HEIGHT);
		eightSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.eight_spades, WIDTH, HEIGHT);
		nineSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.nine_spades, WIDTH, HEIGHT);
		tenSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ten_spades, WIDTH, HEIGHT);
		jackSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.jack_spades, WIDTH, HEIGHT);
		queenSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.queen_spades, WIDTH, HEIGHT);
		kingSpades =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.kings_spades, WIDTH, HEIGHT);

		aceDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ace_diamonds, WIDTH, HEIGHT);
		deuceDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.deuce_diamonds, WIDTH, HEIGHT);
		threeDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.three_diamonds, WIDTH, HEIGHT);
		fourDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.four_diamonds, WIDTH, HEIGHT);
		fiveDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.five_diamonds, WIDTH, HEIGHT);
		sixDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.six_diamonds, WIDTH, HEIGHT);
		sevenDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.seven_diamonds, WIDTH, HEIGHT);
		eightDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.eight_diamonds, WIDTH, HEIGHT);
		nineDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.nine_diamonds, WIDTH, HEIGHT);
		tenDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ten_diamonds, WIDTH, HEIGHT);
		jackDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.jack_diamonds, WIDTH, HEIGHT);
		queenDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.queen_diamonds, WIDTH, HEIGHT);
		kingDiamonds =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.king_diamonds, WIDTH, HEIGHT);

		aceHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ace_hearts, WIDTH, HEIGHT);
		deuceHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.deuce_hearts, WIDTH, HEIGHT);
		threeHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.three_hearts, WIDTH, HEIGHT);
		fourHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.four_hearts, WIDTH, HEIGHT);
		fiveHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.five_hearts, WIDTH, HEIGHT);
		sixHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.six_hearts, WIDTH, HEIGHT);
		sevenHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.seven_hearts, WIDTH, HEIGHT);
		eightHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.eight_hearts, WIDTH, HEIGHT);
		nineHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.nine_hearts, WIDTH, HEIGHT);
		tenHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ten_hearts, WIDTH, HEIGHT);
		jackHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.jack_hearts, WIDTH, HEIGHT);
		queenHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.queen_hearts, WIDTH, HEIGHT);
		kingHearts =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.king_hearts, WIDTH, HEIGHT);

		aceClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ace_clubs, WIDTH, HEIGHT);
		deuceClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.deuce_clubs, WIDTH, HEIGHT);
		threeClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.three_clubs, WIDTH, HEIGHT);
		fourClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.four_clubs, WIDTH, HEIGHT);
		fiveClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.five_clubs, WIDTH, HEIGHT);
		sixClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.six_clubs, WIDTH, HEIGHT);
		sevenClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.seven_clubs, WIDTH, HEIGHT);
		eightClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.eight_clubs, WIDTH, HEIGHT);
		nineClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.nine_clubs, WIDTH, HEIGHT);
		tenClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.ten_clubs, WIDTH, HEIGHT);
		jackClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.jack_clubs, WIDTH, HEIGHT);
		queenClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.queen_clubs, WIDTH, HEIGHT);
		kingClubs =  decodeSampledBitmapFromResource(context.getResources(),
				R.drawable.king_clubs, WIDTH, HEIGHT);

	}

}
