package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.R;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.PresenceUtils;
import d0.z.d.Intrinsics3;

/* compiled from: StatusView.kt */
/* loaded from: classes2.dex */
public final class StatusView extends AppCompatImageView {

    /* renamed from: j, reason: from kotlin metadata */
    public float cornerRadius;

    /* renamed from: k, reason: from kotlin metadata */
    public Paint backgroundPaint;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean showMobile;

    /* renamed from: m, reason: from kotlin metadata */
    public boolean isCircle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.cornerRadius = 2.0f;
        this.showMobile = true;
        this.isCircle = true;
        setAdjustViewBounds(true);
        setScaleType(ImageView.ScaleType.FIT_XY);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.StatusView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.StatusView, 0, 0)");
        try {
            setBorderWidth((int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f));
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(color);
            paint.setAntiAlias(true);
            this.backgroundPaint = paint;
            this.showMobile = typedArrayObtainStyledAttributes.getBoolean(3, true);
            this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        if (this.isCircle) {
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            float width2 = getWidth() / 2.0f;
            Paint paint = this.backgroundPaint;
            if (paint == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("backgroundPaint");
            }
            canvas.drawCircle(width, height, width2, paint);
        } else {
            float width3 = getWidth();
            float height2 = getHeight();
            float f = this.cornerRadius;
            Paint paint2 = this.backgroundPaint;
            if (paint2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("backgroundPaint");
            }
            canvas.drawRoundRect(0.0f, 0.0f, width3, height2, f, f, paint2);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        paint.setAntiAlias(true);
        this.backgroundPaint = paint;
    }

    public final void setBorderWidth(@Px int borderWidthPx) {
        setPadding(borderWidthPx, borderWidthPx, borderWidthPx, borderWidthPx);
    }

    public final void setCornerRadius(@Px float cornerRadius) {
        this.cornerRadius = cornerRadius;
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setPresence(Presence presence) {
        int i;
        ClientStatuses clientStatuses;
        ClientStatuses clientStatuses2;
        if (!this.showMobile || presence == null || (clientStatuses2 = presence.getClientStatuses()) == null || !PresenceUtils.INSTANCE.isMobile(clientStatuses2)) {
            if ((presence != null ? PresenceUtils.INSTANCE.getStreamingActivity(presence) : null) != null) {
                i = R.drawable.ic_status_streaming_16dp;
            } else {
                ClientStatus status = presence != null ? presence.getStatus() : null;
                if (status != null) {
                    int iOrdinal = status.ordinal();
                    i = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? R.drawable.ic_status_invisible_16dp : R.drawable.ic_status_dnd_16dp : R.drawable.ic_status_idle_16dp : R.drawable.ic_status_online_16dp;
                }
            }
        } else {
            i = R.drawable.ic_mobile;
        }
        setImageResource(i);
        this.isCircle = !(this.showMobile && presence != null && (clientStatuses = presence.getClientStatuses()) != null && PresenceUtils.INSTANCE.isMobile(clientStatuses));
    }
}
