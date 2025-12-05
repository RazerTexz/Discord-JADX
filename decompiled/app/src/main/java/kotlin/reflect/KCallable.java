package kotlin.reflect;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import p507d0.p513e0.KAnnotatedElement;
import p507d0.p513e0.KParameter;
import p507d0.p513e0.KTypeParameter;

/* compiled from: KCallable.kt */
/* loaded from: classes3.dex */
public interface KCallable<R> extends KAnnotatedElement {
    R call(Object... args);

    R callBy(Map<KParameter, ? extends Object> args);

    String getName();

    List<KParameter> getParameters();

    KType getReturnType();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
