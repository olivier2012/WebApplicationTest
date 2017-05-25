/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author olivier-h
 */
public class fileData implements Comparable<fileData> {
    private String filename;
    private long  filesize;
    
    public fileData(String filename, long filesize){
      this.filename = filename;
      this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }
    
    @Override
    public String toString(){
      return (filename==null ? "":filename)+"-"+filesize;
    }
    
    @Override
    public int compareTo(fileData other){
      return Long.compare(filesize,other.filesize);
    }
}
