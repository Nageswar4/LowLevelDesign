package com.example.demo.splitting;

import java.util.Map;

import com.example.demo.beans.SplitType;

public class SplittingStrategyFactory {
	private static final Map<SplitType, SplittingStrategy> strategies = Map.of(SplitType.EQUAL, new EqualSplit(),
			SplitType.PERCENTAGE, new PercentageSplit());

	public static SplittingStrategy getStrategy(SplitType type) {
		return strategies.get(type);
	}
}
