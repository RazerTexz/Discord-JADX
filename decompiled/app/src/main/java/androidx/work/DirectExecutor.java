package androidx.work;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DirectExecutor.kt */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Intrinsics3.checkParameterIsNotNull(command, "command");
        command.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
