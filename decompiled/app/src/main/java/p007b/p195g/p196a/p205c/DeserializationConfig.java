package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.p210c0.SimpleMixInResolver;
import p007b.p195g.p196a.p205c.p212e0.SubtypeResolver;
import p007b.p195g.p196a.p205c.p214f0.JsonNodeFactory;
import p007b.p195g.p196a.p205c.p219i0.LinkedNode;
import p007b.p195g.p196a.p205c.p219i0.RootNameLookup;
import p007b.p195g.p196a.p205c.p221z.BaseSettings;
import p007b.p195g.p196a.p205c.p221z.CoercionConfigs;
import p007b.p195g.p196a.p205c.p221z.ConfigOverrides;
import p007b.p195g.p196a.p205c.p221z.ConstructorDetector;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;
import p007b.p195g.p196a.p205c.p221z.MapperConfigBase;

/* JADX INFO: renamed from: b.g.a.c.f, reason: use source file name */
/* JADX INFO: compiled from: DeserializationConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationConfig extends MapperConfigBase<DeserializationFeature, DeserializationConfig> implements Serializable {

    /* JADX INFO: renamed from: l */
    public static final int f4781l = MapperConfig.m2264c(DeserializationFeature.class);
    private static final long serialVersionUID = 2;
    public final CoercionConfigs _coercionConfigs;
    public final ConstructorDetector _ctorDetector;
    public final int _deserFeatures;
    public final int _formatReadFeatures;
    public final int _formatReadFeaturesToChange;
    public final JsonNodeFactory _nodeFactory;
    public final int _parserFeatures;
    public final int _parserFeaturesToChange;
    public final LinkedNode<?> _problemHandlers;

    public DeserializationConfig(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides, CoercionConfigs coercionConfigs) {
        super(baseSettings, subtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this._deserFeatures = f4781l;
        this._nodeFactory = JsonNodeFactory.f4783k;
        this._ctorDetector = null;
        this._coercionConfigs = coercionConfigs;
        this._parserFeatures = 0;
        this._parserFeaturesToChange = 0;
        this._formatReadFeatures = 0;
        this._formatReadFeaturesToChange = 0;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfigBase
    /* JADX INFO: renamed from: r */
    public MapperConfigBase mo1969r(int i) {
        return new DeserializationConfig(this, i, this._deserFeatures, this._parserFeatures, this._parserFeaturesToChange, this._formatReadFeatures, this._formatReadFeaturesToChange);
    }

    public DeserializationConfig(DeserializationConfig deserializationConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        super(deserializationConfig, i);
        this._deserFeatures = i2;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._coercionConfigs = deserializationConfig._coercionConfigs;
        this._ctorDetector = deserializationConfig._ctorDetector;
        this._parserFeatures = i3;
        this._parserFeaturesToChange = i4;
        this._formatReadFeatures = i5;
        this._formatReadFeaturesToChange = i6;
    }
}
