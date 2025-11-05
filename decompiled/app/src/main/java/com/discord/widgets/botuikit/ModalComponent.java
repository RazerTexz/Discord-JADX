package com.discord.widgets.botuikit;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.botuikit.ActionRowComponent;
import com.discord.api.botuikit.TextComponent;
import com.discord.api.botuikit.TextStyle;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.app.AppFragment;
import com.discord.databinding.BotUikitTextInputBinding;
import com.discord.databinding.ViewInteractionModalBinding;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.t.t;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ModalComponent.kt */
/* loaded from: classes2.dex */
public final class ModalComponent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(ModalComponent.class, "binding", "getBinding()Lcom/discord/databinding/ViewInteractionModalBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_OPTIONS = "extra_options";

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String sentNonce;

    /* compiled from: ModalComponent.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, Options options) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(options, "options");
            Intent intent = new Intent();
            intent.putExtra("extra_options", options);
            j.d(context, ModalComponent.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ModalComponent.kt */
    public static final /* data */ class Options implements Parcelable {
        public static final Parcelable.Creator<Options> CREATOR = new Creator();
        private final InteractionModalCreate modal;

        public static class Creator implements Parcelable.Creator<Options> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options createFromParcel(Parcel parcel) {
                m.checkNotNullParameter(parcel, "in");
                return new Options((InteractionModalCreate) parcel.readSerializable());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Options createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options[] newArray(int i) {
                return new Options[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Options[] newArray(int i) {
                return newArray(i);
            }
        }

        public Options(InteractionModalCreate interactionModalCreate) {
            m.checkNotNullParameter(interactionModalCreate, "modal");
            this.modal = interactionModalCreate;
        }

        public static /* synthetic */ Options copy$default(Options options, InteractionModalCreate interactionModalCreate, int i, Object obj) {
            if ((i & 1) != 0) {
                interactionModalCreate = options.modal;
            }
            return options.copy(interactionModalCreate);
        }

        /* renamed from: component1, reason: from getter */
        public final InteractionModalCreate getModal() {
            return this.modal;
        }

        public final Options copy(InteractionModalCreate modal) {
            m.checkNotNullParameter(modal, "modal");
            return new Options(modal);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Options) && m.areEqual(this.modal, ((Options) other).modal);
            }
            return true;
        }

        public final InteractionModalCreate getModal() {
            return this.modal;
        }

        public int hashCode() {
            InteractionModalCreate interactionModalCreate = this.modal;
            if (interactionModalCreate != null) {
                return interactionModalCreate.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("Options(modal=");
            sbU.append(this.modal);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            m.checkNotNullParameter(parcel, "parcel");
            parcel.writeSerializable(this.modal);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreApplicationInteractions.SentInteractionState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreApplicationInteractions.SentInteractionState.SUCCESS.ordinal()] = 1;
            iArr[StoreApplicationInteractions.SentInteractionState.FAILURE.ordinal()] = 2;
        }
    }

    /* compiled from: ModalComponent.kt */
    /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = ModalComponent.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: ModalComponent.kt */
    /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ List $components;
        public final /* synthetic */ View $view;

        /* compiled from: ModalComponent.kt */
        /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03582 extends o implements Function1<String, Unit> {
            public C03582() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                m.checkNotNullParameter(str, "nonce");
                ModalComponent.access$setSentNonce$p(ModalComponent.this, str);
            }
        }

        /* compiled from: ModalComponent.kt */
        /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends o implements Function0<Unit> {

            /* compiled from: ModalComponent.kt */
            /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$3$1, reason: invalid class name */
            public static final class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ModalComponent.access$setSentNonce$p(ModalComponent.this, null);
                    LinearLayout linearLayout = ModalComponent.access$getBinding$p(ModalComponent.this).d;
                    m.checkNotNullExpressionValue(linearLayout, "binding.error");
                    linearLayout.setVisibility(0);
                    MaterialButton materialButton = ModalComponent.access$getBinding$p(ModalComponent.this).f;
                    m.checkNotNullExpressionValue(materialButton, "binding.submit");
                    materialButton.setEnabled(true);
                }
            }

            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2.this.$view.post(new AnonymousClass1());
            }
        }

        public AnonymousClass2(List list, View view) {
            this.$components = list;
            this.$view = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            boolean z2 = true;
            for (Pair pair : this.$components) {
                TextComponent textComponent = (TextComponent) pair.component1();
                BotUikitTextInputBinding botUikitTextInputBinding = (BotUikitTextInputBinding) pair.component2();
                TextInputEditText textInputEditText = botUikitTextInputBinding.f2089b;
                m.checkNotNullExpressionValue(textInputEditText, "text.editText");
                String strValueOf = String.valueOf(textInputEditText.getText());
                if (strValueOf.length() == 0) {
                    if (m.areEqual(textComponent.getRequired(), Boolean.TRUE)) {
                        TextInputLayout textInputLayout = botUikitTextInputBinding.d;
                        m.checkNotNullExpressionValue(textInputLayout, "text.layout");
                        textInputLayout.setError(b.k(ModalComponent.this, R.string.form_length_error, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, null, 4));
                        z2 = false;
                    }
                } else if (strValueOf.length() < textComponent.getMinLength() || strValueOf.length() > textComponent.getMaxLength()) {
                    TextInputLayout textInputLayout2 = botUikitTextInputBinding.d;
                    m.checkNotNullExpressionValue(textInputLayout2, "text.layout");
                    textInputLayout2.setError(b.k(ModalComponent.this, R.string.form_length_error, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, null, 4));
                    z2 = false;
                }
                arrayList.add(new Pair(textComponent.getCustomId(), strValueOf));
            }
            if (z2) {
                ModalComponent.access$setSentNonce$p(ModalComponent.this, null);
                LinearLayout linearLayout = ModalComponent.access$getBinding$p(ModalComponent.this).d;
                m.checkNotNullExpressionValue(linearLayout, "binding.error");
                linearLayout.setVisibility(8);
                MaterialButton materialButton = ModalComponent.access$getBinding$p(ModalComponent.this).f;
                m.checkNotNullExpressionValue(materialButton, "binding.submit");
                materialButton.setEnabled(false);
                StoreStream.INSTANCE.getInteractions().sendModalInteraction(ModalComponent.this.getArgs().getModal(), arrayList, new C03582(), new AnonymousClass3());
            }
        }
    }

    /* compiled from: ModalComponent.kt */
    /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Map<String, ? extends StoreApplicationInteractions.SentInteraction>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreApplicationInteractions.SentInteraction> map) {
            invoke2((Map<String, StoreApplicationInteractions.SentInteraction>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<String, StoreApplicationInteractions.SentInteraction> map) {
            StoreApplicationInteractions.SentInteraction sentInteraction;
            FragmentActivity activity;
            m.checkNotNullParameter(map, "sentInteractions");
            String strAccess$getSentNonce$p = ModalComponent.access$getSentNonce$p(ModalComponent.this);
            if (strAccess$getSentNonce$p == null || (sentInteraction = map.get(strAccess$getSentNonce$p)) == null) {
                return;
            }
            int iOrdinal = sentInteraction.getState().ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2 && (activity = ModalComponent.this.getActivity()) != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            ModalComponent.access$setSentNonce$p(ModalComponent.this, null);
            LinearLayout linearLayout = ModalComponent.access$getBinding$p(ModalComponent.this).d;
            m.checkNotNullExpressionValue(linearLayout, "binding.error");
            linearLayout.setVisibility(0);
            MaterialButton materialButton = ModalComponent.access$getBinding$p(ModalComponent.this).f;
            m.checkNotNullExpressionValue(materialButton, "binding.submit");
            materialButton.setEnabled(true);
        }
    }

    public ModalComponent() {
        this(0, 1, null);
    }

    public ModalComponent(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ModalComponent$binding$2.INSTANCE, null, 2, null);
        this.args = g.lazy(new ModalComponent$$special$$inlined$args$1(this, "extra_options"));
    }

    public static final /* synthetic */ ViewInteractionModalBinding access$getBinding$p(ModalComponent modalComponent) {
        return modalComponent.getBinding();
    }

    public static final /* synthetic */ String access$getSentNonce$p(ModalComponent modalComponent) {
        return modalComponent.sentNonce;
    }

    public static final /* synthetic */ void access$setSentNonce$p(ModalComponent modalComponent, String str) {
        modalComponent.sentNonce = str;
    }

    private final ViewInteractionModalBinding getBinding() {
        return (ViewInteractionModalBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Options getArgs() {
        return (Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(getArgs().getModal().getTitle());
        SimpleDraweeView simpleDraweeView = getBinding().e;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.icon");
        simpleDraweeView.setContentDescription(getArgs().getModal().getApplication().getName());
        SimpleDraweeView simpleDraweeView2 = getBinding().e;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.icon");
        IconUtils.setApplicationIcon(simpleDraweeView2, StoreApplicationCommandsKt.toDomainApplication(getArgs().getModal().getApplication()));
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.warning");
        b.n(textView2, R.string.interaction_form_submission_application, new Object[]{getArgs().getModal().getApplication().getName()}, null, 4);
        List listFilterIsInstance = t.filterIsInstance(getArgs().getModal().b(), ActionRowComponent.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            Object orNull = u.getOrNull(((ActionRowComponent) it.next()).b(), 0);
            if (!(orNull instanceof TextComponent)) {
                orNull = null;
            }
            TextComponent textComponent = (TextComponent) orNull;
            if (textComponent != null) {
                arrayList.add(textComponent);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            TextComponent textComponent2 = (TextComponent) it2.next();
            View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.bot_uikit_text_input, (ViewGroup) null, false);
            int i = R.id.edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(R.id.edit_text);
            if (textInputEditText != null) {
                i = R.id.label;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.label);
                if (textView3 != null) {
                    i = R.id.layout;
                    TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.layout);
                    if (textInputLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        BotUikitTextInputBinding botUikitTextInputBinding = new BotUikitTextInputBinding(linearLayout, textInputEditText, textView3, textInputLayout);
                        m.checkNotNullExpressionValue(botUikitTextInputBinding, "BotUikitTextInputBinding…r.from(requireContext()))");
                        m.checkNotNullExpressionValue(textView3, "textInput.label");
                        textView3.setText(textComponent2.getLabel());
                        m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        textInputLayout.setCounterMaxLength(textComponent2.getMaxLength());
                        m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new ModalComponent$onViewBound$components$2$1(botUikitTextInputBinding));
                        textInputEditText.setText(textComponent2.getValue());
                        m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                        textInputEditText.setHint(textComponent2.getPlaceholder());
                        if (textComponent2.getStyle() == TextStyle.PARAGRAPH) {
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(5);
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(131073);
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMinHeight(DimenUtils.dpToPixels(96));
                        } else {
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(1);
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(1);
                        }
                        getBinding().c.addView(linearLayout);
                        arrayList2.add(new Pair(textComponent2, botUikitTextInputBinding));
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        getBinding().f2200b.setOnClickListener(new AnonymousClass1());
        getBinding().f.setOnClickListener(new AnonymousClass2(arrayList2, view));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getInteractions().observeSentInteractions(), this, null, 2, null), ModalComponent.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public /* synthetic */ ModalComponent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.view_interaction_modal : i);
    }
}
