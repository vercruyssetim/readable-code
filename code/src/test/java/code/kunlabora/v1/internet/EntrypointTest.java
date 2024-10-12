package code.kunlabora.v1.internet;

import code.kunlabora.v1.internet.Entrypoint;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EntrypointTest {

    private Entrypoint entrypoint = new Entrypoint();

    @Test
    void test() {
        Assertions.assertThat(entrypoint.DONEXT(1)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(1)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(2)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(2)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(3)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(3)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(4)).isEqualTo("true");
    }

    @Test
    void test2() {
        Assertions.assertThat(entrypoint.DONEXT(1)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(1)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(2)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(3)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(3)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(2)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(4)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(4)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(5)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(5)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(5)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(5)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(6)).isEqualTo("false");
        Assertions.assertThat(entrypoint.DONEXT(6)).isEqualTo("false");

        Assertions.assertThat(entrypoint.DONEXT(7)).isEqualTo("true");
    }
  
}