package com.discord.views;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p000.C13002p;
import p007b.p008a.p025i.OverlayBubbleMenuBinding;
import p007b.p008a.p025i.OverlayMenuVoiceMembersItemBinding;
import p007b.p008a.p062y.OverlayAppDialog2;
import p007b.p008a.p062y.OverlayMenuBubbleDialog2;
import p007b.p008a.p062y.OverlayMenuBubbleDialog4;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog extends OverlayAppDialog2 implements AppComponent {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final SimpleRecyclerAdapter<StoreVoiceParticipants.VoiceUser, C7081a> adapter;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public final OverlayBubbleMenuBinding binding;

    /* JADX INFO: renamed from: com.discord.views.OverlayMenuBubbleDialog$a */
    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class C7081a extends SimpleRecyclerAdapter.ViewHolder<StoreVoiceParticipants.VoiceUser> {

        /* JADX INFO: renamed from: a */
        public final OverlayMenuVoiceMembersItemBinding f19095a;

        /* JADX WARN: Illegal instructions before constructor call */
        public C7081a(OverlayMenuVoiceMembersItemBinding overlayMenuVoiceMembersItemBinding) {
            Intrinsics3.checkNotNullParameter(overlayMenuVoiceMembersItemBinding, "binding");
            VoiceUserView voiceUserView = overlayMenuVoiceMembersItemBinding.f1433a;
            Intrinsics3.checkNotNullExpressionValue(voiceUserView, "binding.root");
            super(voiceUserView);
            this.f19095a = overlayMenuVoiceMembersItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(StoreVoiceParticipants.VoiceUser voiceUser) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
            Intrinsics3.checkNotNullParameter(voiceUser2, "data");
            this.f19095a.f1433a.m8570a(voiceUser2, C5419R.dimen.avatar_size_extra_large);
        }
    }

    /* JADX INFO: renamed from: com.discord.views.OverlayMenuBubbleDialog$b */
    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class C7082b<T, R> implements Func1<Long, Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>>> {

        /* JADX INFO: renamed from: j */
        public static final C7082b f19096j = new C7082b();

        @Override // p637j0.p641k.Func1
        public Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>> call(Long l) {
            Long l2 = l;
            StoreChannels channels = StoreStream.INSTANCE.getChannels();
            Intrinsics3.checkNotNullExpressionValue(l2, "channelId");
            return channels.observeChannel(l2.longValue()).m11099Y(new OverlayMenuBubbleDialog4(l2));
        }
    }

    /* JADX INFO: renamed from: com.discord.views.OverlayMenuBubbleDialog$c */
    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class C7083c<T, R> implements Func1<List<? extends StoreVoiceParticipants.VoiceUser>, Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer>> {

        /* JADX INFO: renamed from: j */
        public static final C7083c f19097j = new C7083c();

        @Override // p637j0.p641k.Func1
        public Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> call(List<? extends StoreVoiceParticipants.VoiceUser> list) {
            List<? extends StoreVoiceParticipants.VoiceUser> list2 = list;
            ArrayList arrayListM840a0 = outline.m840a0(list2, "voiceUsers");
            for (T t : list2) {
                if (!((StoreVoiceParticipants.VoiceUser) t).isMe()) {
                    arrayListM840a0.add(t);
                }
            }
            int size = arrayListM840a0.size();
            return (size >= 0 && 3 >= size) ? Tuples.m10073to(arrayListM840a0, 0) : Tuples.m10073to(_Collections.take(arrayListM840a0, 3), Integer.valueOf(arrayListM840a0.size() - 3));
        }
    }

    /* JADX INFO: renamed from: com.discord.views.OverlayMenuBubbleDialog$d */
    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class C7084d extends Lambda implements Function1<Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer>, Unit> {
        public C7084d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> tuples2) {
            String string;
            Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> tuples22 = tuples2;
            List<? extends StoreVoiceParticipants.VoiceUser> listComponent1 = tuples22.component1();
            int iIntValue = tuples22.component2().intValue();
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
            TextView textView = overlayMenuBubbleDialog.binding.f1395d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.overlayMembersOverflowTv");
            ViewExtensions.setTextAndVisibilityBy(textView, string);
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuBubbleDialog(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.overlay_bubble_menu, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.overlay_header;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.overlay_header);
        if (linearLayout != null) {
            i = C5419R.id.overlay_linked_anchor_view;
            View viewFindViewById = viewInflate.findViewById(C5419R.id.overlay_linked_anchor_view);
            if (viewFindViewById != null) {
                i = C5419R.id.overlay_members_overflow_tv;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.overlay_members_overflow_tv);
                if (textView != null) {
                    i = C5419R.id.overlay_members_rv;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.overlay_members_rv);
                    if (recyclerView != null) {
                        i = C5419R.id.overlay_menu;
                        OverlayMenuView overlayMenuView = (OverlayMenuView) viewInflate.findViewById(C5419R.id.overlay_menu);
                        if (overlayMenuView != null) {
                            OverlayBubbleMenuBinding overlayBubbleMenuBinding = new OverlayBubbleMenuBinding((LinearLayout) viewInflate, linearLayout, viewFindViewById, textView, recyclerView, overlayMenuView);
                            Intrinsics3.checkNotNullExpressionValue(overlayBubbleMenuBinding, "OverlayBubbleMenuBinding…rom(context), this, true)");
                            this.binding = overlayBubbleMenuBinding;
                            this.adapter = new SimpleRecyclerAdapter<>(null, OverlayMenuBubbleDialog2.f2050j, 1, null);
                            overlayMenuView.setOnDismissRequested$app_productionGoogleRelease(new C13002p(0, this));
                            setClipChildren(false);
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // p007b.p008a.p062y.OverlayAppDialog2
    public Animator getClosingAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(getResources().getInteger(R.integer.config_shortAnimTime));
        OverlayMenuView overlayMenuView = this.binding.f1397f;
        Intrinsics3.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView.getContext(), C5419R.animator.overlay_slide_down_fade_out);
        animatorLoadAnimator.setTarget(this.binding.f1397f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), C5419R.animator.overlay_slide_up_fade_out);
        animatorLoadAnimator2.setTarget(this.binding.f1393b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        return animatorSet;
    }

    public final View getLinkedAnchorView() {
        View view = this.binding.f1394c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.overlayLinkedAnchorView");
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OverlayMenuView overlayMenuView = this.binding.f1397f;
        Intrinsics3.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        overlayMenuView.setAlpha(0.0f);
        LinearLayout linearLayout = this.binding.f1393b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.overlayHeader");
        linearLayout.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        OverlayMenuView overlayMenuView2 = this.binding.f1397f;
        Intrinsics3.checkNotNullExpressionValue(overlayMenuView2, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView2.getContext(), C5419R.animator.overlay_slide_up_fade_in);
        animatorLoadAnimator.setTarget(this.binding.f1397f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), C5419R.animator.overlay_slide_down_fade_in);
        animatorLoadAnimator2.setTarget(this.binding.f1393b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        animatorSet.setStartDelay(getResources().getInteger(R.integer.config_shortAnimTime));
        animatorSet.start();
        RecyclerView recyclerView = this.binding.f1396e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.overlayMembersRv");
        recyclerView.setAdapter(this.adapter);
        Observable observableM11083G = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId().m11099Y(C7082b.f19096j).m11083G(C7083c.f19097j);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "StoreStream\n        .get…- 3\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11083G), this, null, 2, null), OverlayMenuBubbleDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C7084d(), 62, (Object) null);
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getOnDialogClosed().invoke(this);
    }
}
