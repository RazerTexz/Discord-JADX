package lombok.patcher;

import java.security.ProtectionDomain;

/* loaded from: discord-126021.apk:lombok/patcher/Filter.SCL.lombok */
public interface Filter {
    public static final Filter ALWAYS = new C129101();

    boolean shouldTransform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr);

    /* renamed from: lombok.patcher.Filter$1 */
    /* loaded from: discord-126021.apk:lombok/patcher/Filter$1.SCL.lombok */
    class C129101 implements Filter {
        C129101() {
        }

        @Override // lombok.patcher.Filter
        public boolean shouldTransform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            return true;
        }
    }
}
