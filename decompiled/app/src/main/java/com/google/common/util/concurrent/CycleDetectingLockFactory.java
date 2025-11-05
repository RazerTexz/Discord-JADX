package com.google.common.util.concurrent;

import b.i.a.f.e.o.f;
import b.i.b.b.r;
import b.i.b.b.u;
import b.i.b.b.v;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.logging.Logger;

@CanIgnoreReturnValue
/* loaded from: classes3.dex */
public class CycleDetectingLockFactory {

    public static final class PotentialDeadlockException extends b {
        private final b conflictingStackTrace;

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable cause = this.conflictingStackTrace; cause != null; cause = cause.getCause()) {
                sb.append(", ");
                sb.append(cause.getMessage());
            }
            return sb.toString();
        }
    }

    public static class a extends ThreadLocal<ArrayList<c>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<c> initialValue() {
            f.A(3, "initialArraySize");
            return new ArrayList<>(3);
        }
    }

    public static class b extends IllegalStateException {
        static {
            r.r(CycleDetectingLockFactory.class.getName(), b.class.getName(), c.class.getName());
        }
    }

    public static class c {
    }

    static {
        u uVar = new u();
        uVar.d(v.p.k);
        uVar.c();
        Logger.getLogger(CycleDetectingLockFactory.class.getName());
        new a();
    }
}
