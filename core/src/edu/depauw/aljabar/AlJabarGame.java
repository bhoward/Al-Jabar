package edu.depauw.aljabar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class AlJabarGame extends ApplicationAdapter {
	private Stage stage;
	private GameState state = new GameState(4); // TODO eventually do this from
												// home screen
	public static ButtonStyle[] bStyles;
	public static Button playButton;
	public static Button passButton;
	public static Button lastButton;
	public static Button drawButton;
	public static Table[] player;
	public static Drawable highlight;

	public void create() {
		Skin rbySkin = new Skin();
		rbySkin.add("playUp", new Texture("play.png"));
		rbySkin.add("playDn", new Texture("play.png"));
		rbySkin.add("playCk", new Texture("play.png"));

		rbySkin.add("passUp", new Texture("pass.png"));
		rbySkin.add("passDn", new Texture("pass.png"));
		rbySkin.add("passCk", new Texture("pass.png"));

		rbySkin.add("drawUp", new Texture("draw.png"));
		rbySkin.add("drawDn", new Texture("draw.png"));
		rbySkin.add("drawCk", new Texture("draw.png"));

		rbySkin.add("lastUp", new Texture("last.png"));
		rbySkin.add("lastDn", new Texture("last.png"));
		rbySkin.add("lastCk", new Texture("lastSel.png"));

		rbySkin.add("homeUp", new Texture("home.png"));
		rbySkin.add("homeDn", new Texture("home.png"));
		rbySkin.add("homeCk", new Texture("home.png"));

		rbySkin.add("b000Up", new Texture("b000.png"));
		rbySkin.add("b000Dn", new Texture("b000.png"));
		rbySkin.add("b000Ck", new Texture("b000SelA.png"));

		rbySkin.add("b001Up", new Texture("b001.png"));
		rbySkin.add("b001Dn", new Texture("b001.png"));
		rbySkin.add("b001Ck", new Texture("b001SelA.png"));

		rbySkin.add("b010Up", new Texture("b010.png"));
		rbySkin.add("b010Dn", new Texture("b010.png"));
		rbySkin.add("b010Ck", new Texture("b010SelA.png"));

		rbySkin.add("b011Up", new Texture("b011.png"));
		rbySkin.add("b011Dn", new Texture("b011.png"));
		rbySkin.add("b011Ck", new Texture("b011SelA.png"));

		rbySkin.add("b100Up", new Texture("b100.png"));
		rbySkin.add("b100Dn", new Texture("b100.png"));
		rbySkin.add("b100Ck", new Texture("b100SelA.png"));

		rbySkin.add("b101Up", new Texture("b101.png"));
		rbySkin.add("b101Dn", new Texture("b101.png"));
		rbySkin.add("b101Ck", new Texture("b101SelA.png"));

		rbySkin.add("b110Up", new Texture("b110.png"));
		rbySkin.add("b110Dn", new Texture("b110.png"));
		rbySkin.add("b110Ck", new Texture("b110SelA.png"));

		rbySkin.add("b111Up", new Texture("b111.png"));
		rbySkin.add("b111Dn", new Texture("b111.png"));
		rbySkin.add("b111Ck", new Texture("b111SelA.png"));

		rbySkin.add("highlight", new Texture("highlight.png"));

		highlight = rbySkin.getDrawable("highlight");

		stage = new Stage(new StretchViewport(300, 200));
		Gdx.input.setInputProcessor(stage);

		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		Table leftUp = new Table();
		Table leftMid = new Table();
		Table leftDown = new Table();
		Table left = new Table();

		Table centerUp = new Table();
		Table centerMid = new Table();
		Table centerDown = new Table();
		Table center = new Table();

		Texture button = new Texture("b000.png");
		float buttonWidth = button.getWidth();
		float buttonScale = 10 / buttonWidth; // make the buttons 10 logical
												// units wide

		bStyles = new ButtonStyle[8];

		bStyles[0] = new ButtonStyle(rbySkin.getDrawable("b000Up"),
				rbySkin.getDrawable("b000Dn"), rbySkin.getDrawable("b000Ck"));
		Button b000a = new Button(bStyles[0]);
		Button b000b = new Button(bStyles[0]);
		Button b000c = new Button(bStyles[0]);
		
		final Button[] centerButton = new Button[8];
		
		bStyles[1] = new ButtonStyle(rbySkin.getDrawable("b001Up"),
				rbySkin.getDrawable("b001Dn"), rbySkin.getDrawable("b001Ck"));

		bStyles[2] = new ButtonStyle(rbySkin.getDrawable("b010Up"),
				rbySkin.getDrawable("b010Dn"), rbySkin.getDrawable("b010Ck"));

		bStyles[3] = new ButtonStyle(rbySkin.getDrawable("b011Up"),
				rbySkin.getDrawable("b011Dn"), rbySkin.getDrawable("b011Ck"));

		bStyles[4] = new ButtonStyle(rbySkin.getDrawable("b100Up"),
				rbySkin.getDrawable("b100Dn"), rbySkin.getDrawable("b100Ck"));

		bStyles[5] = new ButtonStyle(rbySkin.getDrawable("b101Up"),
				rbySkin.getDrawable("b101Dn"), rbySkin.getDrawable("b101Ck"));

		bStyles[6] = new ButtonStyle(rbySkin.getDrawable("b110Up"),
				rbySkin.getDrawable("b110Dn"), rbySkin.getDrawable("b110Ck"));

		bStyles[7] = new ButtonStyle(rbySkin.getDrawable("b111Up"),
				rbySkin.getDrawable("b111Dn"), rbySkin.getDrawable("b111Ck"));

		Group centerGroup = new Group();
		
		int[] bx = new int[] {0,  35, -45,  -5,  -5,  15, -25,  -5};
		int[] by = new int[] {0, -75, -75, -75, -15, -45, -45, -55};

		for (int i = 1; i < 8; i++) {
			Button b = new Button(bStyles[i]);
			b.setTransform(true);
			b.setScale(buttonScale);
			b.setPosition(bx[i], by[i]);
			b.setUserObject(new PlayerColor(state.center, i));
			b.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					super.clicked(event, x, y);

					Button actor = (Button) event.getListenerActor();
					PlayerColor pc1 = (PlayerColor) (actor.getUserObject());
					pc1.player.handle(actor, pc1.color, state);
				}
			});
			b.setVisible(state.center.count[i] == 1);
			centerGroup.addActor(b);
			
			centerButton[i] = b;
		}

		b000a.setTransform(true);
		b000a.setScale(buttonScale);
		b000a.setPosition(-45, -35);
		b000a.setUserObject(new PlayerColor(state.center, 0));
		b000a.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				Button actor = (Button) event.getListenerActor();
				PlayerColor pc1 = (PlayerColor) (actor.getUserObject());
				pc1.player.handle(actor, pc1.color, state);
			}
		});
		centerGroup.addActor(b000a);

		b000b.setTransform(true);
		b000b.setScale(buttonScale);
		b000b.setPosition(35, -35);
		b000b.setUserObject(new PlayerColor(state.center, 0));
		b000b.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				Button actor = (Button) event.getListenerActor();
				PlayerColor pc1 = (PlayerColor) (actor.getUserObject());
				pc1.player.handle(actor, pc1.color, state);
			}
		});
		centerGroup.addActor(b000b);

		b000c.setTransform(true);
		b000c.setScale(buttonScale);
		b000c.setPosition(-5, -95);
		b000c.setUserObject(new PlayerColor(state.center, 0));
		b000c.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				Button actor = (Button) event.getListenerActor();
				PlayerColor pc1 = (PlayerColor) (actor.getUserObject());
				pc1.player.handle(actor, pc1.color, state);
			}
		});
		centerGroup.addActor(b000c);

		center.add(centerGroup);

		// ButtonStyle homeStyle = new
		// ButtonStyle(rbySkin.getDrawable("homeUp"),
		// rbySkin.getDrawable("homeDn"), rbySkin.getDrawable("homeCk"));
		// Button homeButton = new Button(homeStyle);
		//
		// centerUp.add(homeButton).width(50).height(40);

		center.add(centerUp);
		center.row();
		center.add(centerMid).width(100).height(100);
		center.row();
		center.add(centerDown);

		Table rightUp = new Table();
		Table rightMid = new Table();
		Table rightDown = new Table();
		Table right = new Table();

		ButtonStyle playStyle = new ButtonStyle(rbySkin.getDrawable("playUp"),
				rbySkin.getDrawable("playDn"), rbySkin.getDrawable("playCk"));
		playButton = new Button(playStyle);
		playButton.setVisible(false);

		playButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				Player player1 = state.player[state.currentPlayer];
				for (Button b : player1.selected) {
					b.setChecked(false);
					b.setVisible(false);
					b.setStyle(bStyles[Util.getColor(b)]);
				}

				for (Button b : state.center.selected) {
					int color = Util.getColor(b);
					b.setChecked(false);
					if (color != 0)
						b.setVisible(false);
					b.setStyle(bStyles[color]);

					player1.button[color][player1.count[color]]
							.setVisible(true);
					player1.count[color]++;
					if (color != 0)
						state.center.count[color]--;
				}

				int[] oldCount = state.center.count.clone();

				for (Button b : player1.selected) {
					PlayerColor pc = (PlayerColor) b.getUserObject();
					int color = pc.color;

					if (oldCount[color] == 1) {
						oldCount[color] = 0;
						for (int i = 0; i < state.numPlayers; i++) {
							if (i == state.currentPlayer)
								continue;
							Player player2 = state.player[i];
							player2.button[0][player2.count[0]]
									.setVisible(true);
							player2.count[0]++;

						}
					}

					if (color != 0) {
						state.center.count[color] = (state.center.count[color] + 1) % 2;
						centerButton[color].setVisible(state.center.count[color] == 1);
					}
					player1.count[color]--;
				}

				player1.selected.clear();
				state.center.selected.clear();
				state.nextPlayer();
				playButton.setVisible(false);
			}
		});

		ButtonStyle passStyle = new ButtonStyle(rbySkin.getDrawable("passUp"),
				rbySkin.getDrawable("passDn"), rbySkin.getDrawable("passCk"));
		passButton = new Button(passStyle);
		passButton.setVisible(false);

		passButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				state.nextPlayer();
			}
		});

		leftMid.add(playButton).width(50).height(40);
		leftMid.add(passButton).width(50).height(40);

		player = new Table[4];
		for (int i = 0; i < 4; i++) {
			Table pt = new Table();

			for (int row = 0; row < 8; row++) {
				PlayerColor pc = new PlayerColor(state.player[i], row);

				for (int col = 0; col < 10; col++) {
					Button b = new Button(bStyles[row]);
					b.setUserObject(pc);
					b.addListener(new ClickListener() {

						@Override
						public void clicked(InputEvent event, float x, float y) {
							super.clicked(event, x, y);

							Button actor = (Button) event.getListenerActor();
							PlayerColor pc1 = (PlayerColor) (actor
									.getUserObject());
							pc1.player.handle(actor, pc1.color, state);
						}

					});
					b.setVisible(col < state.player[i].count[row]);
					b.setDisabled(i != 0);
					pt.add(b).width(10).height(10);
					state.player[i].button[row][col] = b;
				}
				pt.row();
			}
			player[i] = pt;
		}

		leftUp.add(player[0]);
		leftDown.add(player[3]);
		rightUp.add(player[1]);
		rightDown.add(player[2]);

		player[0].setBackground(highlight);

		left.add(leftUp);
		left.row();
		left.add(leftMid);
		left.row();
		left.add(leftDown);

		ButtonStyle drawStyle = new ButtonStyle(rbySkin.getDrawable("drawUp"),
				rbySkin.getDrawable("drawDn"), rbySkin.getDrawable("drawCk"));
		drawButton = new Button(drawStyle);

		drawButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				int color = state.draw();
				Player player1 = state.player[state.currentPlayer];
				player1.button[color][player1.count[color]].setVisible(true);
				player1.count[color]++;
			}
		});

		ButtonStyle lastStyle = new ButtonStyle(rbySkin.getDrawable("lastUp"),
				rbySkin.getDrawable("lastDn"), rbySkin.getDrawable("lastCk"));
		lastButton = new Button(lastStyle);
		lastButton.setVisible(false);

		lastButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				state.finalRound = true;
				passButton.setVisible(true);
				lastButton.setDisabled(true);
			}
		});

		rightMid.add(drawButton).width(50).height(40);
		rightMid.add(lastButton).width(50).height(40);

		right.add(rightUp);
		right.row();
		right.add(rightMid);
		right.row();
		right.add(rightDown);

		table.add(left).width(100);
		table.add(center).width(100);
		table.add(right).width(100);

		// table.debug();
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	public void render() {
		Gdx.gl.glClearColor(0.6f, 0.6f, 0.6f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

		Table.drawDebug(stage); // This is optional, but enables debug lines for
								// tables.
	}

	public void dispose() {
		stage.dispose();
	}
}
