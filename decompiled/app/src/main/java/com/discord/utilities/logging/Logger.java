package com.discord.utilities.logging;

import android.util.Log;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* compiled from: Logger.kt */
/* loaded from: classes2.dex */
public class Logger {
    private final String defaultTag;

    public Logger(String str) {
        Intrinsics3.checkNotNullParameter(str, "defaultTag");
        this.defaultTag = str;
    }

    public static /* synthetic */ void d$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.d(str, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        logger.e(str, th, map);
    }

    public static /* synthetic */ void i$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.i(str, th);
    }

    public static /* synthetic */ void v$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.v(str, th);
    }

    public static /* synthetic */ void w$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.w(str, th);
    }

    public void d(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        d(this.defaultTag, message, throwable);
    }

    public void e(String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(message, "message");
        e(this.defaultTag, message, throwable, metadata);
    }

    public final String getDefaultTag() {
        return this.defaultTag;
    }

    public final void i(String str) {
        i$default(this, str, null, 2, null);
    }

    public void i(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        i(this.defaultTag, message, throwable);
    }

    public void recordBreadcrumb(String message, String category) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(category, "category");
    }

    public void v(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        v(this.defaultTag, message, throwable);
    }

    public void w(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        w(this.defaultTag, message, throwable);
    }

    public void d(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.d(tag, message, throwable);
        } else {
            Log.d(tag, message);
        }
    }

    public void e(String tag, String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.e(tag, message, throwable);
        } else {
            Log.e(tag, message);
        }
    }

    public void i(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.i(tag, message, throwable);
        } else {
            Log.i(tag, message);
        }
    }

    public void v(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.v(tag, message, throwable);
        } else {
            Log.v(tag, message);
        }
    }

    public void w(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.w(tag, message, throwable);
        } else {
            Log.w(tag, message);
        }
    }

    public static /* synthetic */ void d$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.d(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e$default(Logger logger, String str, String str2, Throwable th, Map map, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            if ((i & 8) != 0) {
                map = null;
            }
            logger.e(str, str2, th, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
    }

    public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.i(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
    }

    public static /* synthetic */ void v$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.v(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
    }

    public static /* synthetic */ void w$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.w(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
    }
}
