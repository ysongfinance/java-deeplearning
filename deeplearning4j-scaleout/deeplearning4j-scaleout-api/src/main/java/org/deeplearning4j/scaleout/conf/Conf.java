package org.deeplearning4j.scaleout.conf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.deeplearning4j.nn.BaseMultiLayerNetwork;
import org.deeplearning4j.nn.NeuralNetwork;
import org.deeplearning4j.nn.activation.ActivationFunction;
import org.deeplearning4j.nn.activation.Sigmoid;
import org.deeplearning4j.transformation.MatrixTransform;


public class Conf implements Serializable,Cloneable {


	private static final long serialVersionUID = 2994146097289344262L;
	private Class<? extends BaseMultiLayerNetwork> multiLayerClazz;
	private Class<? extends NeuralNetwork> neuralNetworkClazz;
	private int k;
	private long seed = 123;
	private double corruptionLevel = 0.3;
	private double sparsity = 0;
	private ActivationFunction function = new Sigmoid();
	private int[] layerSizes = new int[]{300,300,300};
	private int pretrainEpochs = 1000;
	private int finetuneEpochs = 1000;
	private double pretrainLearningRate = 0.01;
	private double finetuneLearningRate = 0.01;
	private int split = 10;
	private int nIn = 1;
	private int nOut = 1;
	private int numPasses = 1;
	private double momentum = 0.1;
	private boolean useRegularization = false;
	private Object[] deepLearningParams;
	private String masterUrl;
	private double l2;
	private Map<Integer,MatrixTransform> weightTransforms = new HashMap<Integer,MatrixTransform>();
	private int renderWeightEpochs = 0;
	
	
	
	
	
	
	
	public synchronized double getSparsity() {
		return sparsity;
	}
	public synchronized void setSparsity(double sparsity) {
		this.sparsity = sparsity;
	}
	public Map<Integer, MatrixTransform> getWeightTransforms() {
		return weightTransforms;
	}
	public void setWeightTransforms(Map<Integer, MatrixTransform> weightTransforms) {
		this.weightTransforms = weightTransforms;
	}
	public double getL2() {
		return l2;
	}
	public void setL2(double l2) {
		this.l2 = l2;
	}
	public String getMasterUrl() {
		return masterUrl;
	}
	public void setMasterUrl(String masterUrl) {
		this.masterUrl = masterUrl;
	}
	public double getMomentum() {
		return momentum;
	}
	public void setMomentum(double momentum) {
		this.momentum = momentum;
	}
	public boolean isUseRegularization() {
		return useRegularization;
	}
	public void setUseRegularization(boolean useRegularization) {
		this.useRegularization = useRegularization;
	}
	public Class<? extends BaseMultiLayerNetwork> getMultiLayerClazz() {
		return multiLayerClazz;
	}
	public void setMultiLayerClazz(
			Class<? extends BaseMultiLayerNetwork> multiLayerClazz) {
		this.multiLayerClazz = multiLayerClazz;
	}
	public Class<? extends NeuralNetwork> getNeuralNetworkClazz() {
		return neuralNetworkClazz;
	}
	public void setNeuralNetworkClazz(
			Class<? extends NeuralNetwork> neuralNetworkClazz) {
		this.neuralNetworkClazz = neuralNetworkClazz;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public long getSeed() {
		return seed;
	}
	public void setSeed(long seed) {
		this.seed = seed;
	}
	public double getCorruptionLevel() {
		return corruptionLevel;
	}
	public void setCorruptionLevel(double corruptionLevel) {
		this.corruptionLevel = corruptionLevel;
	}
	public ActivationFunction getFunction() {
		return function;
	}
	public void setFunction(ActivationFunction function) {
		this.function = function;
	}
	public int[] getLayerSizes() {
		return layerSizes;
	}
	public void setLayerSizes(int[] layerSizes) {
		this.layerSizes = layerSizes;
	}
	
	public void setLayerSizes(Integer[] layerSizes) {
		this.layerSizes = new int[layerSizes.length];
		for(int i = 0; i < layerSizes.length; i++)
			this.layerSizes[i] = layerSizes[i];
	}
	
	public int getPretrainEpochs() {
		return pretrainEpochs;
	}
	public void setPretrainEpochs(int pretrainEpochs) {
		this.pretrainEpochs = pretrainEpochs;
	}
	public double getPretrainLearningRate() {
		return pretrainLearningRate;
	}
	public void setPretrainLearningRate(double pretrainLearningRate) {
		this.pretrainLearningRate = pretrainLearningRate;
	}
	public double getFinetuneLearningRate() {
		return finetuneLearningRate;
	}
	public void setFinetuneLearningRate(double finetuneLearningRate) {
		this.finetuneLearningRate = finetuneLearningRate;
	}
	public int getSplit() {
		return split;
	}
	public void setSplit(int split) {
		this.split = split;
	}
	public int getnIn() {
		return nIn;
	}
	public void setnIn(int nIn) {
		this.nIn = nIn;
	}
	public int getnOut() {
		return nOut;
	}
	public void setnOut(int nOut) {
		this.nOut = nOut;
	}
	public int getNumPasses() {
		return numPasses;
	}
	public void setNumPasses(int numPasses) {
		this.numPasses = numPasses;
	}
	public Object[] getDeepLearningParams() {
		return deepLearningParams;
	}
	public void setDeepLearningParams(Object[] deepLearningParams) {
		this.deepLearningParams = deepLearningParams;
	}

	
	public int getFinetuneEpochs() {
		return finetuneEpochs;
	}
	public void setFinetuneEpochs(int finetuneEpochs) {
		this.finetuneEpochs = finetuneEpochs;
	}
	
	public int getRenderWeightEpochs() {
		return renderWeightEpochs;
	}
	public void setRenderWeightEpochs(int renderWeightEpochs) {
		this.renderWeightEpochs = renderWeightEpochs;
	}
	public Conf copy() {
		return SerializationUtils.clone(this);
	}
	
	/**
	 * Corruption level of 0.3 and learning rate of 0.01
	 * and 1000 epochs
	 * @return
	 */
	public static Object[] getDefaultDenoisingAutoEncoderParams() {
		return new Object[]{0.3,0.01,1000};
	}
	/**
	 * K of 1 and learning rate of 0.01 and 1000 epochs
	 * @return the default parameters for RBMs
	 * and DBNs
	 */
	public static Object[] getDefaultRbmParams() {
		return new Object[]{1,0.01,1000};
	}

}