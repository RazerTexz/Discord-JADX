package com.discord.views;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.y0;
import b.a.i.z0;
import b.a.y.l;
import b.a.y.n;
import b.a.y.p;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: OverlayMenuBubbleDialog.kt */
/* loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog extends l implements AppComponent {

    /* renamed from: A, reason: from kotlin metadata */
    public final SimpleRecyclerAdapter<StoreVoiceParticipants.VoiceUser, a> adapter;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final y0 binding;

    /* compiled from: OverlayMenuBubbleDialog.kt */
    public static final class a extends SimpleRecyclerAdapter.ViewHolder<StoreVoiceParticipants.VoiceUser> {
        public final z0 a;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(z0 z0Var) {
            m.checkNotNullParameter(z0Var, "binding");
            VoiceUserView voiceUserView = z0Var.a;
            m.checkNotNullExpressionValue(voiceUserView, "binding.root");
            super(voiceUserView);
            this.a = z0Var;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(StoreVoiceParticipants.VoiceUser voiceUser) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
            m.checkNotNullParameter(voiceUser2, "data");
            this.a.a.a(voiceUser2, R.dimen.avatar_size_extra_large);
        }
    }

    /* compiled from: OverlayMenuBubbleDialog.kt */
    public static final class b<T, R> implements j0.k.b<Long, Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>>> {
        public static final b j = new b();

        @Override // j0.k.b
        public Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>> call(Long l) {
            Long l2 = l;
            StoreChannels channels = StoreStream.INSTANCE.getChannels();
            m.checkNotNullExpressionValue(l2, "channelId");
            return channels.observeChannel(l2.longValue()).Y(new p(l2));
        }
    }

    /* compiled from: OverlayMenuBubbleDialog.kt */
    public static final class c<T, R> implements j0.k.b<List<? extends StoreVoiceParticipants.VoiceUser>, Pair<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer>> {
        public static final c j = new c();

        @Override // j0.k.b
        public Pair<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> call(List<? extends StoreVoiceParticipants.VoiceUser> list) {
            List<? extends StoreVoiceParticipants.VoiceUser> list2 = list;
            ArrayList arrayListA0 = b.d.b.a.a.a0(list2, "voiceUsers");
            for (T t : list2) {
                if (!((StoreVoiceParticipants.VoiceUser) t).isMe()) {
                    arrayListA0.add(t);
                }
            }
            int size = arrayListA0.size();
            return (size >= 0 && 3 >= size) ? o.to(arrayListA0, 0) : o.to(u.take(arrayListA0, 3), Integer.valueOf(arrayListA0.size() - 3));
        }
    }

    /* compiled from: OverlayMenuBubbleDialog.kt */
    public static final class d extends d0.z.d.o implements Function1<Pair<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Pair<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> pair) {
            String string;
            Pair<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> pair2 = pair;
            List<? extends StoreVoiceParticipants.VoiceUser> listComponent1 = pair2.component1();
            int iIntValue = pair2.component2().intValue();
            OverlayMenuBubbleDialog overlayMenuBubbleDialog = OverlayMenuBubbleDialog.this;
            overlayMenuBubbleDialog.adapter.setData(listComponent1);
            if (iIntValue == 0) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                sb.append(iIntValue);
                string = sb.toString();
            }
            TextView textView = overlayMenuBubbleDialog.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.overlayMembersOverflowTv");
            ViewExtensions.setTextAndVisibilityBy(textView, string);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuBubbleDialog(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.overlay_bubble_menu, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.overlay_header;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.overlay_header);
        if (linearLayout != null) {
            i = R.id.overlay_linked_anchor_view;
            View viewFindViewById = viewInflate.findViewById(R.id.overlay_linked_anchor_view);
            if (viewFindViewById != null) {
                i = R.id.overlay_members_overflow_tv;
                TextView textView = (TextView) viewInflate.findViewById(R.id.overlay_members_overflow_tv);
                if (textView != null) {
                    i = R.id.overlay_members_rv;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.overlay_members_rv);
                    if (recyclerView != null) {
                        i = R.id.overlay_menu;
                        OverlayMenuView overlayMenuView = (OverlayMenuView) viewInflate.findViewById(R.id.overlay_menu);
                        if (overlayMenuView != null) {
                            y0 y0Var = new y0((LinearLayout) viewInflate, linearLayout, viewFindViewById, textView, recyclerView, overlayMenuView);
                            m.checkNotNullExpressionValue(y0Var, "OverlayBubbleMenuBinding…rom(context), this, true)");
                            this.binding = y0Var;
                            this.adapter = new SimpleRecyclerAdapter<>(null, n.j, 1, null);
                            overlayMenuView.setOnDismissRequested$app_productionGoogleRelease(new defpackage.p(0, this));
                            setClipChildren(false);
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // b.a.y.l
    public Animator getClosingAnimator() throws Resources.NotFoundException {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(getResources().getInteger(android.R.integer.config_shortAnimTime));
        OverlayMenuView overlayMenuView = this.binding.f;
        m.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView.getContext(), R.animator.overlay_slide_down_fade_out);
        animatorLoadAnimator.setTarget(this.binding.f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_up_fade_out);
        animatorLoadAnimator2.setTarget(this.binding.f233b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        return animatorSet;
    }

    public final View getLinkedAnchorView() {
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.overlayLinkedAnchorView");
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        OverlayMenuView overlayMenuView = this.binding.f;
        m.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        overlayMenuView.setAlpha(0.0f);
        LinearLayout linearLayout = this.binding.f233b;
        m.checkNotNullExpressionValue(linearLayout, "binding.overlayHeader");
        linearLayout.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        OverlayMenuView overlayMenuView2 = this.binding.f;
        m.checkNotNullExpressionValue(overlayMenuView2, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView2.getContext(), R.animator.overlay_slide_up_fade_in);
        animatorLoadAnimator.setTarget(this.binding.f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_down_fade_in);
        animatorLoadAnimator2.setTarget(this.binding.f233b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        animatorSet.setStartDelay(getResources().getInteger(android.R.integer.config_shortAnimTime));
        animatorSet.start();
        RecyclerView recyclerView = this.binding.e;
        m.checkNotNullExpressionValue(recyclerView, "binding.overlayMembersRv");
        recyclerView.setAdapter(this.adapter);
        Observable observableG = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId().Y(b.j).G(c.j);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…- 3\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), OverlayMenuBubbleDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getOnDialogClosed().invoke(this);
    }
}
