package p600f0.p601e0.p609k.p610i;

import android.util.Log;
import com.discord.utilities.rest.SendUtils;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0._Strings;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AndroidLog.kt */
/* renamed from: f0.e0.k.i.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class AndroidLog2 extends Handler {

    /* renamed from: a */
    public static final AndroidLog2 f25791a = new AndroidLog2();

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        int iMin;
        Intrinsics3.checkParameterIsNotNull(logRecord, "record");
        AndroidLog androidLog = AndroidLog.f25790c;
        String loggerName = logRecord.getLoggerName();
        Intrinsics3.checkExpressionValueIsNotNull(loggerName, "record.loggerName");
        int i = logRecord.getLevel().intValue() > Level.INFO.intValue() ? 5 : logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
        String message = logRecord.getMessage();
        Intrinsics3.checkExpressionValueIsNotNull(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        Intrinsics3.checkParameterIsNotNull(loggerName, "loggerName");
        Intrinsics3.checkParameterIsNotNull(message, "message");
        String strTake = AndroidLog.f25789b.get(loggerName);
        if (strTake == null) {
            strTake = _Strings.take(loggerName, 23);
        }
        if (Log.isLoggable(strTake, i)) {
            if (thrown != null) {
                StringBuilder sbM836X = outline.m836X(message, "\n");
                sbM836X.append(Log.getStackTraceString(thrown));
                message = sbM836X.toString();
            }
            int i2 = 0;
            int length = message.length();
            while (i2 < length) {
                int iIndexOf$default = Strings4.indexOf$default((CharSequence) message, '\n', i2, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i2 + SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM);
                    String strSubstring = message.substring(i2, iMin);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, strTake, strSubstring);
                    if (iMin >= iIndexOf$default) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }
}
