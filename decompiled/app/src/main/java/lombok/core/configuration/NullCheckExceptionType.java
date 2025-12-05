package lombok.core.configuration;

import lombok.core.LombokImmutableList;
import lombok.core.handlers.HandlerUtil;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ExampleValueString("[NullPointerException | IllegalArgumentException | Assertion | JDK | Guava]")
/* loaded from: discord-126021.apk:lombok/core/configuration/NullCheckExceptionType.SCL.lombok */
public abstract class NullCheckExceptionType {
    public static final NullCheckExceptionType ILLEGAL_ARGUMENT_EXCEPTION = new C128331("ILLEGAL_ARGUMENT_EXCEPTION", 0);
    public static final NullCheckExceptionType NULL_POINTER_EXCEPTION = new C128342("NULL_POINTER_EXCEPTION", 1);
    public static final NullCheckExceptionType ASSERTION = new C128353("ASSERTION", 2);
    public static final NullCheckExceptionType JDK = new C128364("JDK", 3);
    public static final NullCheckExceptionType GUAVA = new C128375("GUAVA", 4);
    private static final /* synthetic */ NullCheckExceptionType[] ENUM$VALUES = {ILLEGAL_ARGUMENT_EXCEPTION, NULL_POINTER_EXCEPTION, ASSERTION, JDK, GUAVA};
    private static final LombokImmutableList<String> METHOD_JDK = LombokImmutableList.m10922of("java", "util", "Objects", "requireNonNull");
    private static final LombokImmutableList<String> METHOD_GUAVA = LombokImmutableList.m10924of("com", "google", "common", "base", "Preconditions", "checkNotNull", new String[0]);

    public abstract String getExceptionType();

    public abstract LombokImmutableList<String> getMethod();

    public static NullCheckExceptionType[] values() {
        NullCheckExceptionType[] nullCheckExceptionTypeArr = ENUM$VALUES;
        int length = nullCheckExceptionTypeArr.length;
        NullCheckExceptionType[] nullCheckExceptionTypeArr2 = new NullCheckExceptionType[length];
        System.arraycopy(nullCheckExceptionTypeArr, 0, nullCheckExceptionTypeArr2, 0, length);
        return nullCheckExceptionTypeArr2;
    }

    public static NullCheckExceptionType valueOf(String str) {
        return (NullCheckExceptionType) Enum.valueOf(NullCheckExceptionType.class, str);
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$1 */
    /* loaded from: discord-126021.apk:lombok/core/configuration/NullCheckExceptionType$1.SCL.lombok */
    enum C128331 extends NullCheckExceptionType {
        C128331(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return "java.lang.IllegalArgumentException";
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    }

    private NullCheckExceptionType(String str, int i) {
    }

    /* synthetic */ NullCheckExceptionType(String str, int i, NullCheckExceptionType nullCheckExceptionType) {
        this(str, i);
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$2 */
    /* loaded from: discord-126021.apk:lombok/core/configuration/NullCheckExceptionType$2.SCL.lombok */
    enum C128342 extends NullCheckExceptionType {
        C128342(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return HandlerUtil.DEFAULT_EXCEPTION_FOR_NON_NULL;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$3 */
    /* loaded from: discord-126021.apk:lombok/core/configuration/NullCheckExceptionType$3.SCL.lombok */
    enum C128353 extends NullCheckExceptionType {
        C128353(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$4 */
    /* loaded from: discord-126021.apk:lombok/core/configuration/NullCheckExceptionType$4.SCL.lombok */
    enum C128364 extends NullCheckExceptionType {
        C128364(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return NullCheckExceptionType.access$3();
        }
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$5 */
    /* loaded from: discord-126021.apk:lombok/core/configuration/NullCheckExceptionType$5.SCL.lombok */
    enum C128375 extends NullCheckExceptionType {
        C128375(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return NullCheckExceptionType.access$4();
        }
    }

    static /* synthetic */ LombokImmutableList access$3() {
        return METHOD_JDK;
    }

    static /* synthetic */ LombokImmutableList access$4() {
        return METHOD_GUAVA;
    }

    public String toExceptionMessage(String fieldName, String customMessage) {
        return customMessage == null ? String.valueOf(fieldName) + " is marked non-null but is null" : customMessage.replace("%s", fieldName);
    }
}
