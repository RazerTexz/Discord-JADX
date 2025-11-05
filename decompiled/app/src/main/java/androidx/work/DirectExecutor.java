package androidx.work;

import androidx.annotation.RestrictTo;
import d0.z.d.Intrinsics3;
import java.util.concurrent.Executor;

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
