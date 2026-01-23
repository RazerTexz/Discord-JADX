package androidx.work;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: DirectExecutor.kt */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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
