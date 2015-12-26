package transportsl;

import enums.Position;
import enums.Traffic;

public interface ConstantInfo {
		public double getFare(Position departure,Position destination,Traffic trafficType);
}
