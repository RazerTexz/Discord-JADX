package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.NoWhenBranchMatchedException;
import p007b.p008a.p025i.ViewStreamPreviewBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StreamPreviewView.kt */
/* loaded from: classes2.dex */
public final class StreamPreviewView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewStreamPreviewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_stream_preview, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.stream_preview_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.stream_preview_image);
        if (simpleDraweeView != null) {
            i = C5419R.id.stream_preview_overlay_text;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.stream_preview_overlay_text);
            if (textView != null) {
                i = C5419R.id.stream_preview_placeholder_caption;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.stream_preview_placeholder_caption);
                if (textView2 != null) {
                    ViewStreamPreviewBinding viewStreamPreviewBinding = new ViewStreamPreviewBinding((ConstraintLayout) viewInflate, simpleDraweeView, textView, textView2);
                    Intrinsics3.checkNotNullExpressionValue(viewStreamPreviewBinding, "ViewStreamPreviewBinding…rom(context), this, true)");
                    this.binding = viewStreamPreviewBinding;
                    setClickable(true);
                    setFocusable(false);
                    setFocusableInTouchMode(false);
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void setCaptionText(CharSequence text) {
        TextView textView = this.binding.f1443d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamPreviewPlaceholderCaption");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    private final void setImage(String url) {
        this.binding.f1441b.setImageURI(url);
    }

    private final void setOverlayCaptionText(CharSequence text) {
        TextView textView = this.binding.f1442c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamPreviewOverlayText");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    @MainThread
    /* renamed from: a */
    public final void m8557a(StoreApplicationStreamPreviews.StreamPreview preview, StreamContext.Joinability joinability, boolean isAlreadyWatchingStream) {
        Intrinsics3.checkNotNullParameter(preview, "preview");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        if (preview instanceof StoreApplicationStreamPreviews.StreamPreview.Fetching) {
            setCaptionText(getContext().getString(C5419R.string.stream_preview_loading));
        } else {
            if (!(preview instanceof StoreApplicationStreamPreviews.StreamPreview.Resolved)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreApplicationStreamPreviews.StreamPreview.Resolved resolved = (StoreApplicationStreamPreviews.StreamPreview.Resolved) preview;
            if (resolved.getUrl() != null) {
                setImage(resolved.getUrl());
                setCaptionText(null);
            } else {
                setImage(null);
                if (joinability == StreamContext.Joinability.CAN_CONNECT) {
                    setCaptionText(getContext().getString(C5419R.string.stream_no_preview));
                } else {
                    setCaptionText(null);
                }
            }
        }
        if (isAlreadyWatchingStream) {
            setOverlayCaptionText(FormatUtils.m218j(this, C5419R.string.watch_stream_watching, new Object[0], null, 4));
            return;
        }
        int iOrdinal = joinability.ordinal();
        if (iOrdinal == 0) {
            setOverlayCaptionText(FormatUtils.m218j(this, C5419R.string.join_stream, new Object[0], null, 4));
        } else if (iOrdinal == 1) {
            setOverlayCaptionText(FormatUtils.m218j(this, C5419R.string.unable_to_join_channel_full, new Object[0], null, 4));
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            setOverlayCaptionText(FormatUtils.m218j(this, C5419R.string.channel_locked_short, new Object[0], null, 4));
        }
    }
}
