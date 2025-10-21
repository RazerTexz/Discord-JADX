package com.discord.widgets.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetSettingsAppearanceBinding;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.views.CheckedSetting;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.Result3;
import d0.t.Collections2;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetSettingsAppearance.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAppearance extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAppearance.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAppearanceBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int EASTER_EGG_UNLOCK_TIMEOUT = 5;
    private static final int HOLY_LIGHT_UNLOCK_COUNT = 5;
    private static final int PURE_EVIL_HINT_COUNT = 3;
    private static final int PURE_EVIL_UNLOCK_COUNT = 8;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicInteger holyLightEasterEggCounter;
    private final BehaviorSubject<Integer> newFontScaleSubject;
    private final AtomicInteger pureEvilEasterEggCounter;

    /* renamed from: pureEvilEasterEggSubject$delegate, reason: from kotlin metadata */
    private final Lazy pureEvilEasterEggSubject;
    private ToastManager toastManager;

    /* compiled from: WidgetSettingsAppearance.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsAppearance.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canSeePureEvil;
        private final String currentTheme;
        private final int fontScale;
        private final MeUser meUser;

        /* compiled from: WidgetSettingsAppearance.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Observable<Boolean> easterEggPureEvil) {
                Intrinsics3.checkNotNullParameter(easterEggPureEvil, "easterEggPureEvil");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableI = Observable.i(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUserSettingsSystem().observeSettings(false), easterEggPureEvil, WidgetSettingsAppearance2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n            .…          )\n            }");
                return observableI;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(String str, boolean z2, int i, MeUser meUser) {
            Intrinsics3.checkNotNullParameter(str, "currentTheme");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            this.currentTheme = str;
            this.canSeePureEvil = z2;
            this.fontScale = i;
            this.meUser = meUser;
        }

        public static /* synthetic */ Model copy$default(Model model, String str, boolean z2, int i, MeUser meUser, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = model.currentTheme;
            }
            if ((i2 & 2) != 0) {
                z2 = model.canSeePureEvil;
            }
            if ((i2 & 4) != 0) {
                i = model.fontScale;
            }
            if ((i2 & 8) != 0) {
                meUser = model.meUser;
            }
            return model.copy(str, z2, i, meUser);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCurrentTheme() {
            return this.currentTheme;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanSeePureEvil() {
            return this.canSeePureEvil;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFontScale() {
            return this.fontScale;
        }

        /* renamed from: component4, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Model copy(String currentTheme, boolean canSeePureEvil, int fontScale, MeUser meUser) {
            Intrinsics3.checkNotNullParameter(currentTheme, "currentTheme");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            return new Model(currentTheme, canSeePureEvil, fontScale, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.currentTheme, model.currentTheme) && this.canSeePureEvil == model.canSeePureEvil && this.fontScale == model.fontScale && Intrinsics3.areEqual(this.meUser, model.meUser);
        }

        public final boolean getCanSeePureEvil() {
            return this.canSeePureEvil;
        }

        public final String getCurrentTheme() {
            return this.currentTheme;
        }

        public final int getFontScale() {
            return this.fontScale;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.currentTheme;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.canSeePureEvil;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (((iHashCode + i) * 31) + this.fontScale) * 31;
            MeUser meUser = this.meUser;
            return i2 + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(currentTheme=");
            sbU.append(this.currentTheme);
            sbU.append(", canSeePureEvil=");
            sbU.append(this.canSeePureEvil);
            sbU.append(", fontScale=");
            sbU.append(this.fontScale);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureThemeOption$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public final /* synthetic */ String $settingTheme;

        public AnonymousClass1(String str) {
            this.$settingTheme = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            if (bool.booleanValue()) {
                WidgetSettingsAppearance.access$updateTheme(WidgetSettingsAppearance.this, this.$settingTheme);
            }
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* compiled from: WidgetSettingsAppearance.kt */
        @DebugMetadata(c = "com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1$1", f = "WidgetSettingsAppearance.kt", l = {122}, m = "invokeSuspend")
        /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03221 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int label;

            public C03221(Continuation continuation) {
                super(2, continuation);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass1.this.new C03221(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03221) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (f.P(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetSettingsAppearance.access$getHolyLightEasterEggCounter$p(WidgetSettingsAppearance.this).set(0);
                return Unit.a;
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).l.g(true, true);
            int andIncrement = WidgetSettingsAppearance.access$getHolyLightEasterEggCounter$p(WidgetSettingsAppearance.this).getAndIncrement();
            if (andIncrement != 0) {
                if (andIncrement != 5) {
                    return;
                }
                WidgetSettingsAppearance.access$showHolyLight(WidgetSettingsAppearance.this);
            } else {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(view);
                if (coroutineScope != null) {
                    f.H0(coroutineScope, null, null, new C03221(null), 3, null);
                }
            }
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetSettingsAppearance.kt */
        @DebugMetadata(c = "com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2$1", f = "WidgetSettingsAppearance.kt", l = {Opcodes.F2I}, m = "invokeSuspend")
        /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int label;

            public AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass2.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (f.P(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetSettingsAppearance.access$getPureEvilEasterEggCounter$p(WidgetSettingsAppearance.this).set(0);
                return Unit.a;
            }
        }

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).j.g(true, true);
            if (this.$model.getCanSeePureEvil()) {
                return;
            }
            int andIncrement = WidgetSettingsAppearance.access$getPureEvilEasterEggCounter$p(WidgetSettingsAppearance.this).getAndIncrement();
            if (andIncrement == 0) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(view);
                if (coroutineScope != null) {
                    f.H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                    return;
                }
                return;
            }
            if (3 <= andIncrement && 8 > andIncrement) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                AppToast.h(view.getContext(), FormatUtils.k(WidgetSettingsAppearance.this, R.string.theme_pure_evil_easter_hint, new Object[]{String.valueOf(8 - andIncrement)}, null, 4), 0, WidgetSettingsAppearance.access$getToastManager$p(WidgetSettingsAppearance.this), 4);
            } else if (andIncrement == 8) {
                AppToast.d(WidgetSettingsAppearance.this.getContext(), R.string.theme_pure_evil_easter_reveal, 0, WidgetSettingsAppearance.access$getToastManager$p(WidgetSettingsAppearance.this));
                WidgetSettingsAppearance.access$getPureEvilEasterEggSubject$p(WidgetSettingsAppearance.this).onNext(Boolean.TRUE);
            }
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
            if (bool.booleanValue() && Intrinsics3.areEqual(this.$model.getCurrentTheme(), ModelUserSettings.THEME_DARK)) {
                WidgetSettingsAppearance.access$updateTheme(WidgetSettingsAppearance.this, ModelUserSettings.THEME_PURE_EVIL);
            } else {
                if (bool.booleanValue() || !Intrinsics3.areEqual(this.$model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
                    return;
                }
                WidgetSettingsAppearance.access$updateTheme(WidgetSettingsAppearance.this, ModelUserSettings.THEME_DARK);
            }
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements SeekBar.OnSeekBarChangeListener {
        public AnonymousClass4() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                int i = progress + 80;
                WidgetSettingsAppearance.access$getNewFontScaleSubject$p(WidgetSettingsAppearance.this).onNext(Integer.valueOf(i));
                TextView textView = WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
                textView.setText(WidgetSettingsAppearance.access$getFontScaleString(WidgetSettingsAppearance.this, i, false));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserSettingsSystem().setFontScale(-1);
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSettingsAppearance widgetSettingsAppearance) {
            super(1, widgetSettingsAppearance, WidgetSettingsAppearance.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAppearance$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetSettingsAppearance.access$configureUI((WidgetSettingsAppearance) this.receiver, model);
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
            Intrinsics3.checkNotNullExpressionValue(num, "fontScale");
            userSettingsSystem.setFontScale(num.intValue());
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
            Intrinsics3.checkNotNullExpressionValue(bool, "it");
            userSettingsSystem.setIsSyncThemeEnabled(bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$showHolyLight$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            View view = WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).g;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
            view.setVisibility(8);
            WidgetSettingsAppearance.access$tryEnableTorchMode(WidgetSettingsAppearance.this, false);
        }
    }

    /* compiled from: WidgetSettingsAppearance.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$updateTheme$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $theme;

        /* compiled from: WidgetSettingsAppearance.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$updateTheme$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03231 extends Lambda implements Function1<ModelUserSettings, Unit> {
            public C03231() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
                invoke2(modelUserSettings);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserSettings modelUserSettings) {
                Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
                if (Intrinsics3.areEqual(AnonymousClass1.this.$theme, ModelUserSettings.THEME_PURE_EVIL)) {
                    AppToast.g(WidgetSettingsAppearance.this.getActivity(), R.string.theme_pure_evil_updated, 0, null, 12);
                } else {
                    AppToast.g(WidgetSettingsAppearance.this.getActivity(), R.string.theme_updated, 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$theme = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithTheme(Intrinsics3.areEqual(this.$theme, ModelUserSettings.THEME_PURE_EVIL) ? ModelUserSettings.THEME_DARK : this.$theme)), false, 1, null), WidgetSettingsAppearance.this, null, 2, null), StoreUserSettings.class, WidgetSettingsAppearance.this.getActivity(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C03231(), 60, (Object) null);
        }
    }

    public WidgetSettingsAppearance() {
        super(R.layout.widget_settings_appearance);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAppearance3.INSTANCE, null, 2, null);
        this.newFontScaleSubject = BehaviorSubject.k0();
        this.pureEvilEasterEggSubject = LazyJVM.lazy(WidgetSettingsAppearance4.INSTANCE);
        this.pureEvilEasterEggCounter = new AtomicInteger(0);
        this.holyLightEasterEggCounter = new AtomicInteger(0);
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAppearance widgetSettingsAppearance, Model model) {
        widgetSettingsAppearance.configureUI(model);
    }

    public static final /* synthetic */ WidgetSettingsAppearanceBinding access$getBinding$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.getBinding();
    }

    public static final /* synthetic */ String access$getFontScaleString(WidgetSettingsAppearance widgetSettingsAppearance, int i, boolean z2) {
        return widgetSettingsAppearance.getFontScaleString(i, z2);
    }

    public static final /* synthetic */ AtomicInteger access$getHolyLightEasterEggCounter$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.holyLightEasterEggCounter;
    }

    public static final /* synthetic */ BehaviorSubject access$getNewFontScaleSubject$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.newFontScaleSubject;
    }

    public static final /* synthetic */ AtomicInteger access$getPureEvilEasterEggCounter$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.pureEvilEasterEggCounter;
    }

    public static final /* synthetic */ BehaviorSubject access$getPureEvilEasterEggSubject$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.getPureEvilEasterEggSubject();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.toastManager;
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetSettingsAppearance widgetSettingsAppearance, ToastManager toastManager) {
        widgetSettingsAppearance.toastManager = toastManager;
    }

    public static final /* synthetic */ void access$showHolyLight(WidgetSettingsAppearance widgetSettingsAppearance) {
        widgetSettingsAppearance.showHolyLight();
    }

    public static final /* synthetic */ void access$tryEnableTorchMode(WidgetSettingsAppearance widgetSettingsAppearance, boolean z2) {
        widgetSettingsAppearance.tryEnableTorchMode(z2);
    }

    public static final /* synthetic */ void access$updateTheme(WidgetSettingsAppearance widgetSettingsAppearance, String str) {
        widgetSettingsAppearance.updateTheme(str);
    }

    private final void configureFontScalingUI(int fontScale) {
        FragmentActivity activity;
        ContentResolver contentResolver;
        int systemFontScaleInt = (fontScale != -1 || (activity = getActivity()) == null || (contentResolver = activity.getContentResolver()) == null) ? fontScale : FontUtils.INSTANCE.getSystemFontScaleInt(contentResolver);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
        textView.setText(getFontScaleString(systemFontScaleInt, fontScale == -1));
        SeekBar seekBar = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setProgress(systemFontScaleInt - 80);
    }

    private final void configureThemeOption(CheckedSetting checkedSetting, String str) {
        checkedSetting.setOnCheckedListener(new AnonymousClass1(str));
    }

    private final void configureUI(Model model) {
        boolean z2 = !Intrinsics3.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_LIGHT);
        getBinding().l.g(!z2, false);
        CheckedSetting checkedSetting = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceThemeLightRadio");
        configureThemeOption(checkedSetting, ModelUserSettings.THEME_LIGHT);
        getBinding().l.e(new AnonymousClass1());
        getBinding().j.g(z2, false);
        CheckedSetting checkedSetting2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAppearanceThemeDarkRadio");
        configureThemeOption(checkedSetting2, ModelUserSettings.THEME_DARK);
        getBinding().j.e(new AnonymousClass2(model));
        if (Intrinsics3.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
            CheckedSetting.d(getBinding().m, null, 1);
        }
        getBinding().m.g(Intrinsics3.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL), false);
        CheckedSetting checkedSetting3 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsAppearanceThemePureEvilSwitch");
        checkedSetting3.setVisibility(model.getCanSeePureEvil() ? 0 : 8);
        getBinding().m.setOnCheckedListener(new AnonymousClass3(model));
        configureFontScalingUI(model.getFontScale());
        getBinding().f.setOnSeekBarChangeListener(new AnonymousClass4());
        getBinding().e.setOnClickListener(AnonymousClass5.INSTANCE);
        setupMessage(model);
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().k, getBinding().h, getBinding().c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }

    private final WidgetSettingsAppearanceBinding getBinding() {
        return (WidgetSettingsAppearanceBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getFontScaleString(int fontScale, boolean useSystemFontScale) {
        if (useSystemFontScale) {
            return fontScale + "% (" + getString(R.string.accessibility_font_scaling_use_os) + ')';
        }
        return fontScale + "% (" + getString(R.string.accessibility_font_scaling_use_app) + ')';
    }

    public static /* synthetic */ String getFontScaleString$default(WidgetSettingsAppearance widgetSettingsAppearance, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return widgetSettingsAppearance.getFontScaleString(i, z2);
    }

    private final BehaviorSubject<Boolean> getPureEvilEasterEggSubject() {
        return (BehaviorSubject) this.pureEvilEasterEggSubject.getValue();
    }

    private final void setupMessage(Model model) {
        SimpleDraweeView simpleDraweeView = getBinding().f2602b.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatItem.chatListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, model.getMeUser(), R.dimen.avatar_size_standard, null, null, null, 56, null);
        TextView textView = getBinding().f2602b.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatItem.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        TextView textView2 = getBinding().f2602b.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatItem.chatListAdapterItemTextName");
        textView2.setText(model.getMeUser().getUsername());
        TextView textView3 = getBinding().f2602b.g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatItem.chatListAdapterItemTextTimestamp");
        textView3.setText(TimeUtils.toReadableTimeString$default(requireContext(), ClockFactory.get().currentTimeMillis(), null, 4, null));
        LinkifiedTextView linkifiedTextView = getBinding().f2602b.f2338b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.chatItem.chatListAdapterItemText");
        linkifiedTextView.setText(getString(R.string.user_settings_appearance_preview_message_1));
    }

    private final void showHolyLight() {
        AppToast.d(getContext(), R.string.theme_holy_light_reveal, 0, this.toastManager);
        tryEnableTorchMode(true);
        View view = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
        view.setVisibility(0);
        Observable<Long> observableD0 = Observable.d0(3L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .timer(3, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    private final void tryEnableTorchMode(boolean enabled) {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = getContext();
            CameraManager cameraManager = (CameraManager) (context != null ? context.getSystemService(ChatInputComponentTypes.CAMERA) : null);
            if (cameraManager != null) {
                try {
                    String[] cameraIdList = cameraManager.getCameraIdList();
                    if (cameraIdList == null || (str = cameraIdList[0]) == null) {
                        return;
                    }
                    cameraManager.setTorchMode(str, enabled);
                } catch (Exception e) {
                    AppLog.g.w("Unable to turn on flashlight", e);
                }
            }
        }
    }

    private final void updateTheme(String theme) {
        StoreStream.INSTANCE.getUserSettingsSystem().setTheme(theme, true, new AnonymousClass1(theme));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toastManager.close();
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(R.string.appearance);
        setActionBarSubtitle(R.string.user_settings);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        SeekBar seekBar = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setMax(70);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Boolean> pureEvilEasterEggSubject = getPureEvilEasterEggSubject();
        Intrinsics3.checkNotNullExpressionValue(pureEvilEasterEggSubject, "pureEvilEasterEggSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(pureEvilEasterEggSubject), this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        Observable<Integer> observableP = this.newFontScaleSubject.p(400L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "newFontScaleSubject\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceSyncSwitch");
        checkedSetting.setChecked(StoreStream.INSTANCE.getUserSettingsSystem().getIsThemeSyncEnabled());
        getBinding().i.setOnCheckedListener(AnonymousClass3.INSTANCE);
    }
}
