package bankaccount;

public interface IRate {
	
	// Returns base rate
	default double getBaseRate() {
		return 3.5;
	}
}
