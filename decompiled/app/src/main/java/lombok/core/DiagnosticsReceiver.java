package lombok.core;

/* loaded from: discord-126021.apk:lombok/core/DiagnosticsReceiver.SCL.lombok */
public interface DiagnosticsReceiver {
    public static final DiagnosticsReceiver CONSOLE = new C128121();

    void addError(String str);

    void addWarning(String str);

    /* renamed from: lombok.core.DiagnosticsReceiver$1 */
    /* loaded from: discord-126021.apk:lombok/core/DiagnosticsReceiver$1.SCL.lombok */
    class C128121 implements DiagnosticsReceiver {
        C128121() {
        }

        @Override // lombok.core.DiagnosticsReceiver
        public void addError(String message) {
            System.err.println("Error: " + message);
        }

        @Override // lombok.core.DiagnosticsReceiver
        public void addWarning(String message) {
            System.out.println("Warning: " + message);
        }
    }
}
