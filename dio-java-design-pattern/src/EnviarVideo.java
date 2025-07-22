public class EnviarVideo {
    private Upload upload;

    public void setUpload(Upload upload) {
        this.upload = upload;
    }

    public void upload(){
        upload.enviar();
    }
}
