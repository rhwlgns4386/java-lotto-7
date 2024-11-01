package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WonTest {

    @ParameterizedTest
    @CsvSource(value = {"999,true", "1001,false"})
    void 해당금액보다_낮은_금액인지_확인(int amount, boolean result) {
        assertThat(new Won(1000).isLessThan(new Won(amount))).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1001,true", "2000,false"})
    void 거스름돈이_있는지_확인한다(int amount, boolean result) {
        assertThat(new Won(amount).hasChange(new Won(1000))).isEqualTo(result);
    }
}
