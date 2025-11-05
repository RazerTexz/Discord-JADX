package b.a.q;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import com.discord.rtcconnection.enums.ThermalStatus;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.LoggingProvider;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: ThermalDetector.kt */
@AnyThread
@RequiresApi(29)
/* loaded from: classes.dex */
public final class i0 implements PowerManager.OnThermalStatusChangedListener, Runnable, DebugPrintable {
    public static boolean k;
    public static boolean l;
    public static boolean m;
    public static final i0 n = new i0();
    public static final Lazy j = d0.g.lazy(d0.i.NONE, a.j);

    /* compiled from: ThermalDetector.kt */
    public static final class a extends d0.z.d.o implements Function0<Handler> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    public final ThermalStatus a() {
        ThermalStatus.Companion companion = ThermalStatus.INSTANCE;
        Application application = ApplicationProvider.INSTANCE.get();
        Objects.requireNonNull(companion);
        d0.z.d.m.checkNotNullParameter(application, "context");
        Object systemService = application.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return companion.a(((PowerManager) systemService).getCurrentThermalStatus());
    }

    public final void b(ThermalStatus thermalStatus) {
        LoggingProvider.INSTANCE.get().recordBreadcrumb("thermalStatus = " + thermalStatus, "thermal");
        switch (thermalStatus.ordinal()) {
            case 0:
                if (!l) {
                    b.c.a.a0.d.e1("ThermalDetector", "totally cool: thermal status is nominal");
                    break;
                } else {
                    b.c.a.a0.d.d1("ThermalDetector", "totally cool: no longer in thermal trouble");
                    l = false;
                    if (m) {
                        ((Handler) j.getValue()).removeCallbacks(this);
                        m = false;
                        break;
                    }
                }
                break;
            case 1:
            case 2:
                if (!l) {
                    b.c.a.a0.d.e1("ThermalDetector", "pretty warm: ignoring low priority thermal status = " + thermalStatus);
                    break;
                } else {
                    b.c.a.a0.d.d1("ThermalDetector", "cooling down: thermal status = " + thermalStatus);
                    c();
                    break;
                }
            case 3:
            case 4:
            case 5:
            case 6:
                if (!l) {
                    b.c.a.a0.d.f1("ThermalDetector", "we're starting to be in thermal trouble");
                    l = true;
                }
                String str = "very toasty: thermal status = " + thermalStatus;
                if (thermalStatus.compareTo(ThermalStatus.Emergency) < 0) {
                    b.c.a.a0.d.f1("ThermalDetector", str);
                } else {
                    b.c.a.a0.d.c1("ThermalDetector", str, new RuntimeException(str));
                }
                c();
                break;
        }
    }

    public final void c() {
        if (m) {
            return;
        }
        ((Handler) j.getValue()).postDelayed(this, 1000L);
        m = true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    @AnyThread
    public void debugPrint(DebugPrintBuilder debugPrintBuilder) {
        d0.z.d.m.checkNotNullParameter(debugPrintBuilder, "dp");
        debugPrintBuilder.appendKeyValue("registered", Boolean.valueOf(k));
        debugPrintBuilder.appendKeyValue("inThermalTrouble", Boolean.valueOf(l));
        debugPrintBuilder.appendKeyValue("updateScheduled", Boolean.valueOf(m));
        debugPrintBuilder.appendKeyValue("currentThermalStatus", a());
    }

    @Override // android.os.PowerManager.OnThermalStatusChangedListener
    public synchronized void onThermalStatusChanged(int i) {
        ThermalStatus thermalStatusA = ThermalStatus.INSTANCE.a(i);
        b.c.a.a0.d.b1("ThermalDetector", "system update: onThermalStatusChanged( " + thermalStatusA + " )");
        b(thermalStatusA);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        m = false;
        ThermalStatus thermalStatusA = a();
        b.c.a.a0.d.b1("ThermalDetector", "scheduled update: current thermal status = " + thermalStatusA);
        b(thermalStatusA);
    }

    public synchronized String toString() {
        return "ThermalDetector(registered=" + k + ", inThermalTrouble=" + l + ", updateScheduled=" + m + ')';
    }
}
