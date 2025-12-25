package com.mrbysco.expressivegolems;

import net.minecraft.resources.Identifier;
import net.minecraft.util.StringRepresentable;

public enum GolemFace implements StringRepresentable {
	DEFAULT("default"),
	CREEPER("creeper"),
	GOODTIMESWITH("goodtimeswith"),
	HAPPY("happy"),
	PANDA("panda"),
	RANDOM_1("random_1"),
	RANDOM_2("random_2"),
	RANDOM_3("random_3"),
	SLIME("slime"),
	SPIDER("spider"),
	STRIDER("strider"),
	UNDEAD("undead");

	private final String name;

	GolemFace(String name) {
		this.name = name;
	}

	public Identifier getTextureLocation() {
		return ExpressiveGolems.modLoc("textures/entity/snow_golem/face/" + this.name + "_face.png");
	}

	public static final StringRepresentable.EnumCodec<GolemFace> CODEC = StringRepresentable.fromEnum(GolemFace::values);

	@Override
	public String getSerializedName() {
		return this.name;
	}

	public static GolemFace getRandomFace() {
		GolemFace[] faces = values();
		return faces[(int) (Math.random() * faces.length)];
	}
}
